package com.jdbc.action;

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
		g1.setUser_name("п║од");
		g1.setAge(23);
		g1.setSex(1);
		g1.setBirthday(new Date());
		g1.setEmail("18888888888");
		g1.setCreate_user("ADMIN");
		g1.setUpdate_user("ADMIN");
		g1.setIsdel(1);
		
		g.addGoddess(g1);
	}
}