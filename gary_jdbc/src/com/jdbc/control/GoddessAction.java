package com.jdbc.control;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jdbc.model.Goddess;
import com.jdbc.model.GoddessDao;

public class GoddessAction {
	public void add(Goddess goddess) throws SQLException{
		GoddessDao dao = new GoddessDao();
		goddess.setSex(1);
		goddess.setCreate_user("ADMIN");
		goddess.setUpdate_user("ADMIN");
		goddess.setIsdel(0);
		dao.addGoddess(goddess);
	}
	public void edit(Goddess goddess) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.updateGoddess(goddess);
	}
	public void del(Integer id) throws SQLException{
		GoddessDao dao = new GoddessDao();
		dao.delGoddess(id);
	}
	public List<Goddess> query() throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.query();
	}
	public Goddess querybyid(Integer id) throws Exception{
		GoddessDao dao = new GoddessDao();
		return dao.querybyid(id);
	}
	public List<Goddess> query(List<Map<String,Object>> params) throws SQLException{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}
	
}