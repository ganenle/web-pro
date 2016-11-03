package com.gary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private FilterConfig config;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		//�޸ı��룬��ֹ����
		String character = config.getInitParameter("character");
		if(character == null){
			character = "utf-8";
		}
		req.setCharacterEncoding(character);
		HttpSession session = req.getSession();
		System.out.println("uri:"+req.getRequestURI());
		System.out.println("url:"+req.getRequestURL());
		String nofilterpaths = config.getInitParameter("noFilterpaths");
		if(nofilterpaths != null){
			String[] strArray = nofilterpaths.split(";");
			for(int i=0;i<strArray.length;i++){
				if(strArray[i]==null || "".equals(strArray[i])){
					continue;
				}
				if(req.getRequestURI().indexOf(strArray[i]) != -1 ){
					//�������
					chain.doFilter(request, response);
					return;
				}
			}
		}
		
		//������ڵ�½��Ϣ
		if(session.getAttribute("username")!=null){
			//�������
			System.out.println(session.getAttribute("username"));
			chain.doFilter(request, response);
		}else{
			res.sendRedirect("login.jsp");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

}
