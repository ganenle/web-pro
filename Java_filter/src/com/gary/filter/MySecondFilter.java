package com.gary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MySecondFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy---MySecondFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("start...doFilter..MySecondFilter");
		chain.doFilter(request, response);
		System.out.println("end...doFilter..MySecondFilter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init..MySecondFilter");
	}

}
