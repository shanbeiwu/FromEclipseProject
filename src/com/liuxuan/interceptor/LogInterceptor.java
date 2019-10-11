package com.neusoft.lemis.rest.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.lemis.entity.r.RestLog;
import com.neusoft.sl.common.base.bl.bo.SLBLO;

public class LogInterceptor extends SLBLO implements HandlerInterceptor {
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3) throws Exception {
		ResponseReaderHttpServletResponseWrapper mResp = new ResponseReaderHttpServletResponseWrapper(response);
		byte[] bytes = mResp.getBytes(); // 获取缓存的响应数据
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		ServletRequest requestWrapper = new RequestReaderHttpServletRequestWrapper(request);
		String body = HttpHelper.getBodyString(requestWrapper);
		return true;
	}
}
