package com.jdbc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.sql.Date;
import java.util.List;

public class GoddessDao {
	/**
	 * @author Gary
	 * @param g
	 * @throws SQLException 
	 * @throws Exception
	 * @增加女神
	 */
	public void addGoddess(Goddess g) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = ""+"insert into imooc_goddess"+"(user_name,sex,age,birthday,email,mobile,"+
		"create_user,create_date,update_user,update_date,isdel) "+
		"values("+"?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//给sql语句传递参数
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4,  new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		ptmt.execute();
		
	}
	public void updateGoddess(Goddess g) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = ""+" update imooc_goddess "+
		" set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,"+
		" update_user=?,update_date=current_date(),isdel=? "+
		" where id=? ";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//给sql语句传递参数
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4,  new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9, g.getId());
		ptmt.execute();
	}
	public void delGoddess(Integer id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql = ""+"delete from imooc_goddess"+
		" where id=?";
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql);
		//给sql语句传递参数
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	public List<Goddess> query() throws Exception{
		Connection conn = DBUtil.getConnection();
		Statement sta = conn.createStatement();
		ResultSet rs=sta.executeQuery("select * from imooc_goddess");
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while(rs.next()){
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("create_user"));
			g.setIsdel(rs.getInt("isdel"));
			gs.add(g);
		}
		return gs;
	}
	public List<Goddess> querybyname(String name) throws SQLException{
		List<Goddess> gl = new ArrayList<Goddess>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from imooc_goddess");
		sql.append(" where user_name=?");
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql.toString());
		//给sql语句传递参数
		ptmt.setString(1, name);
		ResultSet rs = ptmt.executeQuery();
		Goddess g = null;
		while(rs.next()){
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("create_user"));
			g.setIsdel(rs.getInt("isdel"));
			gl.add(g);
		}
		return gl;
	}
	public Goddess querybyid(Integer id) throws SQLException{
		Connection conn = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from imooc_goddess");
		sql.append(" where id=?");
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql.toString());
		//给sql语句传递参数
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		Goddess g = null;
		while(rs.next()){
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("create_user"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}
	public List<Goddess> query(List<Map<String,Object>> params) throws SQLException{
		List<Goddess> gl = new ArrayList<Goddess>();
		Connection conn = DBUtil.getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from imooc_goddess where 1=1");
		if(params != null && params.size()>0){
			for(int i = 0; i<params.size();i++){
				Map<String, Object> map = params.get(i);
				sql.append(" and "+map.get("name") + " " + map.get("rela")+ " " + map.get("value"));
			}
		}
		//预编译sql语句
		PreparedStatement ptmt = conn.prepareStatement(sql.toString());
		//给sql语句传递参数
		ResultSet rs = ptmt.executeQuery();
		Goddess g = null;
		while(rs.next()){
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("create_date"));
			g.setUpdate_user(rs.getString("create_user"));
			g.setIsdel(rs.getInt("isdel"));
			gl.add(g);
		}
		return gl;
	}
	
}
