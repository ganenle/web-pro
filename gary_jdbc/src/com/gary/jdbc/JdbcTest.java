package com.gary.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jdbc.control.GoddessAction;
import com.jdbc.model.Goddess;
import com.jdbc.model.GoddessDao;

public class JdbcTest {

	public static void main(String[] args) throws Exception{
		GoddessAction action = new GoddessAction();
		
		Goddess g1 = new Goddess();
		g1.setUser_name("小夏");
		g1.setAge(23);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("2342355@qq.com");
		g1.setMobile("18888888888");
		g1.setCreate_user("ADMIN");
		g1.setUpdate_user("ADMIN");
		g1.setIsdel(1);
		//action.addGoddess(g1);
		//action.updateGoddess(g1);
		//action.delGoddess(3);
		
		//多条件查询
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> param= new HashMap<String,Object>();
		param.put("name", "user_name");
		param.put("rela", "like");
		param.put("value", "'%小溪%'");
		params.add(param);
		List<Goddess> gdl = new ArrayList<Goddess>();
		gdl = action.query(params);
		for(Goddess g3 : gdl){
			System.out.println(g3.toString());
		}
		
		//id查询
		Goddess gd2 = new Goddess();
		gd2 = action.querybyid(1);
		System.out.println(gd2.toString());
	}
}
