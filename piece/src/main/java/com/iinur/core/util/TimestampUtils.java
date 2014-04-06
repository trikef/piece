package com.iinur.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimestampUtils {

	private static final String FORMAT_DATE_HYPHEN = "yyyy-MM-dd";
	private static final String FORMAT_DATE_SLASH = "yyyy/MM/dd";

	public static Timestamp parseDate(String date) throws ParseException{
		DateFormat df = new SimpleDateFormat(FORMAT_DATE_HYPHEN);
		Timestamp time = null;
		try {
			time = new Timestamp(df.parse(date).getTime());
		} catch (ParseException e) {
			df = new SimpleDateFormat(FORMAT_DATE_SLASH);
			time = new Timestamp(df.parse(date).getTime());
		}
		return time;
	}
}
