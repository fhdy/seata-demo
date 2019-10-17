package com.sly.seata.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化相关工具类
 * 
 * @author rokeRen
 */

@Component
public class DateFormatUtil {

	public final String FORMAT_YYYY = "yyyy";

	public final String FORMAT_YYYYMM = "yyyyMM";

	public final String FORMAT_YYYYMMDD = "yyyyMMdd";

	public final String FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public final String FORMAT_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

	public final String FORMAT_YYYY_MM = "yyyy-MM";

	public final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	public final String FORMATyyyyMMdd_CHN = "yyyy年MM月dd日";

	public final static String FORMAT_yyyy_MM_dd_HH_mmss_cn = "yyyy-MM-dd HH:mm:ss";

	public final Integer DAY_MOLIS = 1000 * 60 * 60 * 24;
	public final Integer HOUR_MOLIS = 1000 * 60 * 60;
	public final Integer MINUTE_MOLIS = 1000 * 60;
	public final Integer SECOND_MOLIS = 1000;

	/**
	 * 获取long类型时间 格式(yyyyMMddHHmmssSSS)
	 */
	public Long selectUTSRetrunLong() {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyyMMddHHmmssSSS);
		String value = sdf.format(new Date());
		return new Long(value);
	}

	/**
	 * 获取String类型时间 格式(yyyyMMddHHmmssSSS)
	 */
	public String selectUTSRetrunString() {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyyMMddHHmmssSSS);
		String value = sdf.format(new Date());
		return value;
	}

	/**
	 * 获取String类型时间
	 * 格式(yyyy-MM-dd HH:mm:ss)
	 */
	public String selectUTSRString(){
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyy_MM_dd_HH_mmss_cn);
		String value = sdf.format(new Date());
		return value;
	}

	/**
	 * 获取date类型时间
	 */
	public Date selectUTSRetrunDate() {
		return new Date();
	}

	/**
	 * 获取Timestamp类型时间
	 */
	public Timestamp selectUTSRetrunTSP() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 格式化传入的字符串进行再次格式
	 * 
	 * @param str
	 *            时间字符串
	 * @param sourFormat
	 *            源时间字符串格式
	 * @param tagFormat
	 *            转换时间字符串格式
	 */
	public String stringDateFormat(String str, String sourFormat, String tagFormat) throws Exception {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		SimpleDateFormat sour = new SimpleDateFormat(sourFormat);
		SimpleDateFormat tag = new SimpleDateFormat(tagFormat);
		Date date = sour.parse(str);
		return tag.format(date);
	}

	/**
	 * 解析时间
	 * 
	 * @param time
	 *            时间字符串
	 * @param format
	 *            时间字符串格式
	 */
	public Date stringToDate(String time, String format) throws Exception {
		if (StringUtils.isBlank(time)) {
			return null;
		}
		SimpleDateFormat formatTime = new SimpleDateFormat(format);
		return formatTime.parse(time);
	}

	/**
	 * 格式化时间
	 * 
	 * @param date
	 *            时间
	 * @param pattern
	 *            转化格式
	 */
	public String dateToString(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 格式化时间 返回Long
	 * 
	 * @param date
	 *            时间
	 * @param pattern
	 *            转化格式
	 */
	public Long dateToLong(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return Long.parseLong(sdf.format(date));
	}

	/**
	 * 格式化时间当前时间
	 */
	public String dateToString(String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}

	/**
	 * Object时间转Date
	 */
	public Date objectToDate(Object obj) {
		if (obj instanceof Date) {
			return (Date) obj;
		}
		return null;
	}
}
