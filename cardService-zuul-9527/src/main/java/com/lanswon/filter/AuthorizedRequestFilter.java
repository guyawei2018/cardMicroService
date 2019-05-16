package com.lanswon.filter;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


public class AuthorizedRequestFilter extends ZuulFilter{

//	过滤器是否生效
	@Override
	public boolean shouldFilter() {
		
		return false;
	}

	@Override
	public Object run() {
		RequestContext context=RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		//处理请求
		String token =request.getParameter("token");
		if(StringUtils.isEmpty(token)) {
			//[1]：设置RouteHost
            URI url;
			try {
				url = new URI("http://localhost:8003/");
				context.setRouteHost(url.toURL());
			} catch (Exception e) {				
				e.printStackTrace();
			}
			context.put(FilterConstants.REQUEST_URI_KEY, "usr/test");			
		}else {
			context.setSendZuulResponse(true);
			context.setResponseStatusCode(200);
			context.set("isSuccess", true);
		}
		
		return null;
	}
	
//	定义filter的类型，有pre、route、post、error四种
	@Override
	public String filterType() {
		return FilterConstants.ROUTE_TYPE;
	}

//	定义filter的顺序，数字越小表示顺序越高，越先执行
	@Override
	public int filterOrder() {
		return 0;
	}

}
