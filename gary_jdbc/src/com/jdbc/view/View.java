package com.jdbc.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.jdbc.control.GoddessAction;
import com.jdbc.model.Goddess;

public class View {
	private static final String CONTEXT="欢迎来到女神禁区：\n" +
			"下面是女神禁区的功能列表：\n" +
			"[MAIN/M]:主菜单\n" +
			"[QUERY/Q]:查看全部女神的信息\n" +
			"[GET/G]:查看某位女神的详细信息\n" +
			"[ADD/A]:添加女神信息\n" +
			"[UPDATE/U]:更新女神信息\n" +
			"[DELETE/D]:删除女神信息\n" +
			"[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n" +
			"[EXIT/E]:退出女神禁区\n" +
			"[BREAK/B]:退出当前功能，返回主菜单";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	
	public static void main(String[] args){
		System.out.println(CONTEXT);
		Scanner scan = new Scanner(System.in);
		Goddess goddess = new Goddess();
		GoddessAction action = new GoddessAction();
		String prenious = null;
		Integer step=1;
		while(scan.hasNext()){//有输入值就循环，没有就不循环
			String in = scan.next().toString();
			if(OPERATION_EXIT.equals(in.toUpperCase()) 
					|| OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
				System.out.println("您已成功推出女神禁区");
				break;
			}else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				try {
					List<Goddess> list=action.query();
					for (Goddess go : list) {
						System.out.println(go.getId()+",姓名："+go.getUser_name());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if(OPERATION_ADD.equals(in.toUpperCase()) 
					|| OPERATION_ADD.substring(0,1).equals(in.toUpperCase())
					|| OPERATION_ADD.equals(prenious)){
				prenious = OPERATION_ADD;
				//新增女神
				switch(step){
					case 1:
						System.out.println("请输入女神的[姓名]");
						break;
					case 2:
						goddess.setUser_name(in);
						System.out.println("请输入女神的［年龄］");
						break;
					case 3:
						goddess.setAge(Integer.valueOf(in));
						System.out.println("请输入女神的［生日］，格式如：yyyy-MM-dd");
						break;
					case 4:
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//格式化器
						try {
							Date birthday = sf.parse(in);
							goddess.setBirthday(birthday);
							System.out.println("请输入女神的［邮箱］");
						} catch (ParseException e) {
							e.printStackTrace();
							System.out.println("您输入的格式有误，请重新输入");
							step = 3;
						}
						break;
					case 5:
						goddess.setEmail(in);
						System.out.println("请输入女神的［手机号］");
						break;
					case 6:
						goddess.setMobile(in);
						try {
							action.add(goddess);
							System.out.println("新增女神成功");
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("新增女神失败");
						}
						break;
					default:break;
				}
				if(OPERATION_ADD.equals(prenious)){
					step++;					
				}
			}else{
				System.out.println("您输入的值为:"+in);
			}
			
		}
	}
}
