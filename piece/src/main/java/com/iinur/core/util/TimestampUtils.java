package com.iinur.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

public class TimestampUtils {

	private static final String FORMAT_DATE_HYPHEN = "yyyy-MM-dd";
	private static final String FORMAT_DATE_SLASH = "yyyy/MM/dd";
	private static final String FORMAT_DATE_KANJI = "yyyy年MM月dd日";

	public static Timestamp parseDate(String date) throws ParseException{
		if(StringUtils.isEmpty(date))return null;
		DateFormat df = new SimpleDateFormat(FORMAT_DATE_HYPHEN);
		Timestamp time = null;
		//TODO change if (Regex(FORMAT...))...
		try {
			time = new Timestamp(df.parse(date).getTime());
		} catch (ParseException e) {
			try {
				df = new SimpleDateFormat(FORMAT_DATE_SLASH);
				time = new Timestamp(df.parse(date).getTime());
			} catch (ParseException e2) {
				df = new SimpleDateFormat(FORMAT_DATE_KANJI);
				time = new Timestamp(df.parse(date).getTime());
			}
		}
		return time;
	}
}
