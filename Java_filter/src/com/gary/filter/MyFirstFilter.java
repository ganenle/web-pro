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

public class MyFirstFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy---MyFirstFilter");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("start...doFilter..MyFirstFilter");
//		arg2.doFilter(arg0, arg1);
		HttpServletRequest request1 = (HttpServletRequest)arg0;
		HttpServletResponse response1 = (HttpServletResponse)arg1;
		//重定向 request
//		response1.sendRedirect(request1.getContextPath()+"/main.jsp");
		//转发 forward
		request1.getRequestDispatcher("/main.jsp").forward(arg0, arg1);
		System.out.println("end...doFilter..MyFirstFilter");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init..MyFirstFilter");
	}

}
