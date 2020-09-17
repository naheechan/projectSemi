package com.semi.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.semi.common.filter.EncyptorWrapper;

/**
 * Servlet Filter implementation class EncyptorFilter
 */
@WebFilter(servletNames = { "enrollMember","login","updatePw" })
public class EncyptorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncyptorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		EncyptorWrapper ew=new EncyptorWrapper((HttpServletRequest)request);
		// pass the request along the filter chain
		chain.doFilter(ew, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
