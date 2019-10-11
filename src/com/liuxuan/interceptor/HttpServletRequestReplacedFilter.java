package com.neusoft.lemis.rest.interceptor;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.lemis.entity.r.RestLog;

public class HttpServletRequestReplacedFilter implements Filter {
	
	private String excludedPage;
    private String[] excludedPages;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		boolean flag = true;
        for (String page:excludedPages) {
        	String reqURL = req.getRequestURI().substring(req.getRequestURI().indexOf("/rest"));
            if (reqURL.equals(page)){
            	System.out.println("next flag turn true");
                flag = false;
            }
        }
        Map<String, RestLog> map = new HashMap<String, RestLog>();
		ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            requestWrapper = new RequestReaderHttpServletRequestWrapper((HttpServletRequest) request);
        }
		if (flag) {
			
	        String body = HttpHelper.getBodyString(requestWrapper);
	        RestLog restLog = new RestLog();
			restLog.setReqmethod(req.getRequestURL().toString());
			restLog.setReqparam(body);
			restLog.setReqtime(new Date());
			map.put("restlog", restLog);
			req.setAttribute("test", map);
		}
		//获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        // 在chain.doFiler方法中传递新的request对象
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		excludedPage = arg0.getInitParameter("fileUpload");//此处的fileUpload就是在web.xml定义的名称一样。
        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(",");
        }
	}

}
