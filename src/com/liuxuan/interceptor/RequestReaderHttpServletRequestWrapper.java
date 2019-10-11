package com.neusoft.lemis.rest.interceptor;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;

public class RequestReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
	
	private final byte[] body;
	
	public RequestReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = HttpHelper.getBodyString(request).getBytes(Charset.forName("UTF-8"));
	}
	
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		
		final ByteArrayInputStream bais = new ByteArrayInputStream(body);
		
		return new ServletInputStream() {
			
			@Override
			public int read() throws IOException {
				return bais.read();
			}
			
			public boolean isFinished() {
				return false;
			}
			
			public boolean isReady() {
				return false;
			}
		};
	}
}
