package com.iinur.piece.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.piece.data.bean.Userinfo;
import com.iinur.piece.model.UserinfoModel;

@InterceptorRefs({
		@InterceptorRef(value = "cookie", params = { "cookiesName", "*",
				"cookiesValue", "*" }), @InterceptorRef("defaultStack"), })
public class UserregiAction extends BaseAction implements CookiesAware,
		ServletResponseAware {

	private static final Logger log = LoggerFactory
			.getLogger(UserregiAction.class);

	private static final String COOKIE_NAME_KEY = "cname";
	private static final String COOKIE_USER_ID_KEY = "cuid";
	
	private static final String COOKIE_ENC = "Windows-31J";

	public String name;
	public int uid;

	public String execute() {
		if (!StringUtils.isEmpty(this.name)) {
			UserinfoModel umodel = new UserinfoModel();
			umodel.registration(this.name);
			Userinfo u = umodel.get(this.name);
			try {
				String nameE = this.name;
				nameE = URLEncoder.encode(this.name, COOKIE_ENC);
				this.uid = u.getId();
				
				Cookie nameCookie = new Cookie(COOKIE_NAME_KEY, nameE);
				Cookie uidCookie = new Cookie(COOKIE_USER_ID_KEY, Integer.toString(this.uid));
				nameCookie.setMaxAge(2 * 360 * 24 * 60 * 60);
				uidCookie.setMaxAge(2 * 360 * 24 * 60 * 60);
				response.addCookie(nameCookie);
				response.addCookie(uidCookie);
			} catch (UnsupportedEncodingException e) {
				log.error(e.getMessage());
			}
		}
		
		notifyCheck(uid);

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
}
