package com.iinur.piece.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
//TODO change Intercepter
@InterceptorRefs({
	  @InterceptorRef(value="cookie" ,
	      params={"cookiesName", "*" ,
	          "cookiesValue" , "*"}),
	  @InterceptorRef("defaultStack"),})
@Results({
	  @Result(name="input", location="userinput.jsp")
	})
public class BaseAction extends ActionSupport implements CookiesAware, ServletResponseAware{

	private static final Logger log = LoggerFactory.getLogger(BaseAction.class);

	private static final String COOKIE_NAME_KEY = "cname";
	private static final String COOKIE_USER_ID_KEY = "cuid";
	private static final String COOKIE_ENC = "Windows-31J";

	public String name;
	public int uid;

	public String before(){
		
		try {
			if (cookie.containsKey(COOKIE_NAME_KEY)&&cookie.containsKey(COOKIE_USER_ID_KEY)) {

				this.name = URLDecoder.decode(
						cookie.get(COOKIE_NAME_KEY), COOKIE_ENC);
				this.uid = Integer.parseInt(URLDecoder.decode(
						cookie.get(COOKIE_USER_ID_KEY), COOKIE_ENC));

			} else {
				return INPUT;
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		}

		return SUCCESS;
	}
	
	private HttpServletResponse response;
	private Map<String, String> cookie;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	
	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookie = cookies;
	}
	
	/*
	 * cookie hunter name
	 */
	private String cname;
	private int cuid;

	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public int getCuid() {
		return cuid;
	}


	public void setCuid(int cuid) {
		this.cuid = cuid;
	}
}