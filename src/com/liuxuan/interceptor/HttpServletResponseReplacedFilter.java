package com.neusoft.lemis.rest.interceptor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.neusoft.lemis.entity.r.RestLog;

import net.sf.json.JSONObject;

public class HttpServletResponseReplacedFilter implements Filter {
	
	
	private String code = "";
	private String data = "";
	private String excludedPage;
    private String[] excludedPages;
	private HibernateTemplate hibernateTemplateHxptNoIntercepter;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ServletContext context = arg0.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		hibernateTemplateHxptNoIntercepter = (HibernateTemplate) ctx.getBean("hibernateTemplateHxptNoIntercepter", HibernateTemplate.class);
		
		excludedPage = arg0.getInitParameter("fileUpload");//此处的fileUpload就是在web.xml定义的名称一样。
        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(",");
        }
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {	
		
		HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        
        boolean flag = true;
        for (String page:excludedPages) {
        	String reqURL = req.getRequestURI().substring(req.getRequestURI().indexOf("/rest"));
            if (reqURL.equals(page)){
            	System.out.println("next flag turn true");
                flag = false;
            }
        }
        ResponseReaderHttpServletResponseWrapper mResp = new ResponseReaderHttpServletResponseWrapper(resp); // 包装响应对象 resp 并缓存响应数据
        filterChain.doFilter(req, mResp);
        byte[] bytes = mResp.getBytes(); // 获取缓存的响应数据
        resp.getOutputStream().write(bytes); // 吧编码数据相应给客户端
        if (flag) {
	      	JSONObject json = JSONObject.fromObject(new String(bytes));
	      	Map<String, RestLog> map = (Map<String, RestLog>) req.getAttribute("test");
	      	code = json.getString("code");
	      	data = json.getString("data") == "null" ? "请求失败，无返回值" : json.getString("data"); //  == null ? "请求失败，无返回值" : json.getString("data")
	      	RestLog restlog = map.get("restlog");
	      	restlog.setRescode(code);
	      	restlog.setResparam(data);
	      	hibernateTemplateHxptNoIntercepter.save(restlog);
        }
	}

	@Override
	public void destroy() {
		System.out.println("this is destory");
	}

}
