package com.jdbc.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdbc.dao.GoddessDao;
import com.jdbc.model.Goddess;

public class GoddessAction {
	public static void main(String[] args) throws Exception{
		GoddessDao g = new GoddessDao();
		/*List<Goddess> gs = g.query();
		for(Goddess goddess : gs){
			System.out.println(goddess.getUser_name()+","+goddess.getAge());
		}*/
		
		Goddess g1 = new Goddess();
		g1.setId(2);
		g1.setUser_name("п║од");
		g1.setAge(23);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("2342355@qq.com");
		g1.setMobile("18888888888");
		g1.setCreate_user("ADMIN");
		g1.setUpdate_user("ADMIN");
		g1.setIsdel(1);
		//g.addGoddess(g1);
		//g.updateGoddess(g1);
		//g.delGoddess(3);
		/*Goddess g2 = g.get(1);
		System.out.println(g2.toString());*/
		List<Goddess> gdl = new ArrayList<Goddess>();
		gdl = g.query();
		for(Goddess g3 : gdl){
			System.out.println(g3.toString());
		}
	}
}