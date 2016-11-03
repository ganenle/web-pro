package com.gary.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName="AsyncFilter",value={"/com.gary.servlet/AsyncServlet"},dispatcherTypes={DispatcherType.REQUEST,DispatcherType.ASYNC},asyncSupported=true)
public class AsynFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy.....AsynFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("start.....AsynFilter");
		chain.doFilter(request, response);
		System.out.println("end.....AsynFilter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init.....AsynFilter");
	}

}
