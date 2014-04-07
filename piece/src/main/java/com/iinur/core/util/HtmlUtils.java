package com.iinur.core.util;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlUtils {

	public static final String MATCH_URL = 
			  "((https?|ftp)(:\\/\\/[-_.!~*\\'()a-zA-Z0-9;\\/?:\\@&=+\\$,%#]+))";
	public static final String REPLACE_LINK = "<a href='$0' target='_blank'>$0</a>";
	public static String replaceLink(String text){
		text = StringEscapeUtils.escapeHtml4(text);
		return text.replaceAll(MATCH_URL, REPLACE_LINK);
	}
}
