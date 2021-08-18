package com.jbac.app.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTimeElapsedFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(PreTimeElapsedFilter.class);
	
	//Validate
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	//Resuelve la logica del filter
	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s request enrutado a %s",
				request.getMethod(),request.getRequestURI().toString()));
		Long startTime = System.currentTimeMillis();
		request.setAttribute("startTime",startTime);
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}