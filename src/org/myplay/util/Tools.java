package org.myplay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FileUtils;

public class Tools {
	private Tools() {
	}

	public static String getHome(HttpServlet httpServlet)
			throws NamingException, SQLException, IOException {
		return new File(httpServlet.getServletContext().getRealPath(""))
				.getCanonicalPath()
				+ File.separator;
	}

	public static final String MAGICSTRING = "AJDIjlapqieDIOoid135015JFGKGgsenvkjeID435489FG";

	public static final long MAGICNUMBER = 0xCAFABABA;

	public static String arrayToString(Object[] s, String esc) {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		if (s != null) {
			for (int i = 0; i < s.length; ++i) {
				sb.append("'");
				sb.append(s[i]);
				sb.append("'");
				sb.append(",");
			}
		}
		return sb.append("'" + esc + "')").toString();
	}

	public static String arrayToString(String[] s, double d) {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		if (s != null) {
			for (int i = 0; i < s.length; ++i) {
				sb.append(s[i]);
				sb.append(",");
			}
		}
		return sb.append(d + ")").toString();
	}

	public static boolean deltree(File dir) throws FileNotFoundException {
		if (dir.exists() && dir.isDirectory()) {
			empty(dir);
			return dir.delete();
		} else {
			throw new FileNotFoundException(dir + " not Found!");
		}
	}

	public static void empty(File dir) throws FileNotFoundException {
		if (dir.exists() && dir.isDirectory()) {
			File[] entries = dir.listFiles();
			int sz = entries.length;
			for (int i = 0; i < sz; i++) {
				if (entries[i].isDirectory()) {
					deltree(entries[i]);
				} else {
					entries[i].delete();
				}
			}
		} else {
			throw new FileNotFoundException("dir not Found!");
		}
	}

	public static String iso2gbk(String str)
			throws UnsupportedEncodingException {
		if (str != null) {
			String str1 = new String(str.getBytes("ISO8859_1"), "GBK");
			return str1;
		} else {
			return null;
		}
	}

	public static String getDate() {
		Calendar calendar = Calendar.getInstance();
		return getDate(calendar, 0);
	}

	public static String getDate(Calendar calendar) {
		return getDate(calendar, 0);
	}

	public static String getDate(int diff) {
		Calendar calendar = Calendar.getInstance();
		return getDate(calendar, diff);
	}

	public static String getDate(Calendar calendar, int diff) {
		calendar.add(Calendar.DATE, diff);
		int date = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		String month1 = String.valueOf(month);
		String date1 = String.valueOf(date);
		if (month <= 9)
			month1 = "0" + month1;
		if (date <= 9)
			date1 = "0" + date1;
		String today = year + "-" + month1 + "-" + date1;
		return today;
	}

	public static String getDateTime() {
		return getDateTime(0);
	}

	public static String getDateTime(int diff) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, diff);
		int date = calendar.get(5);
		int month = calendar.get(2) + 1;
		int year = calendar.get(1);
		int hour = calendar.get(11);
		int minute = calendar.get(12);
		int second = calendar.get(13);
		String dateTime = year + "-" + month + "-" + date + " " + hour + ":"
				+ minute + ":" + second;
		return dateTime;
	}

	public static String getDateTime(long time) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(time);
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(calendar.get(Calendar.YEAR)));
		sb.append("-");
		sb.append(String.valueOf(calendar.get(Calendar.MONTH) + 1));
		sb.append("-");
		sb.append(String.valueOf(calendar.get(Calendar.DATE)));
		sb.append(" ");
		sb.append(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
		sb.append(":");
		sb.append(String.valueOf(calendar.get(Calendar.MINUTE)));
		sb.append(":");
		sb.append(String.valueOf(calendar.get(Calendar.SECOND)));
		return sb.toString();
	}

	public static int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return day_of_week != 0 ? day_of_week : 7;
	}

	public static String getFlownum(int num, String pattern) {
		if (num == 0)
			return "0";
		NumberFormat formatter = new DecimalFormat(pattern);
		return formatter.format(num);
	}

	public static String getFormatedDate() {
		Calendar calendar = Calendar.getInstance();
		int date = calendar.get(Calendar.DATE);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		String month1 = String.valueOf(month);
		String date1 = String.valueOf(date);
		if (month <= 9)
			month1 = "0" + month1;
		if (date <= 9)
			date1 = "0" + date1;
		String today = year + month1 + date1;
		return today;
	}

	public static String getMD5(byte[] b) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(b);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.toUpperCase().substring(1, 3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}

	public static String getTime() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(11);
		int minute = calendar.get(12);
		int second = calendar.get(13);
		String time = hour + ":" + minute + ":" + second;
		return time;
	}

	public static String toHtml(String str) {
		if (str != null) {
			String str1 = new String(str.replaceAll("\"", "&quot;"));
			String str2 = new String(str1.replaceAll(">", "&gt;"));
			String str3 = new String(str2.replaceAll("<", "&lt;"));
			String str4 = new String(str3.replaceAll("\r", "<br>"));
			return str4;
		} else {
			return null;
		}
	}

	public static String nullDate(String n) {
		return (n.startsWith("0000-00-00") ? "" : n.substring(0, 10));
	}

	public static String getStringParameter(HttpServletRequest request,
			String name) {
		return getStringParameter(request, name, "");
	}

	public static String getStringParameter(HttpServletRequest request,
			String name, String def) {
		String s = request.getParameter(name);
		try {
			if("".equals(s)){
				return def;
			}
			return s.trim();
		} catch (Exception e) {
			return def;
		}
	}

	public static String[] getParameterValues(HttpServletRequest request,
			String name) {
		String[] s = request.getParameterValues(name);
		return s == null ? new String[0] : s;
	}

	public static int getIntParameter(HttpServletRequest request, String name) {
		return getIntParameter(request, name, 0);
	}

	public static int getIntParameter(HttpServletRequest request, String name,
			int def) {
		String s = request.getParameter(name);
		try {
			return Integer.parseInt(s.trim());
		} catch (Exception e) {
			return def;
		}

	}

	public static BigDecimal getBigDecimalParameter(HttpServletRequest request,
			String name) {
		return getBigDecimalParameter(request, name, 0);
	}

	public static BigDecimal getBigDecimalParameter(HttpServletRequest request,
			String name, long def) {
		String s = request.getParameter(name);
		try {
			return new BigDecimal(s);
		} catch (Exception e) {
			return new BigDecimal(def);
		}
	}

	public static long getLongParameter(HttpServletRequest request, String name) {
		return getLongParameter(request, name, 0L);
	}

	public static long getLongParameter(HttpServletRequest request,
			String name, long def) {
		String s = request.getParameter(name);
		try {
			return Long.parseLong(s.trim());
		} catch (Exception e) {
			return def;
		}
	}

	public static double getDoubleParameter(HttpServletRequest request,
			String name) {
		return getDoubleParameter(request, name, 0.0D);
	}

	public static double getDoubleParameter(HttpServletRequest request,
			String name, double def) {
		String s = request.getParameter(name);
		try {
			return Double.parseDouble(s.trim());
		} catch (Exception e) {
			return def;
		}

	}

	public static String[] unionArrays(String[] o0, String[] o1) {
		if (o0 == null && o1 == null)
			return null;
		else if (o0 == null || o0.length == 0)
			return o1;
		else if (o1 == null || o1.length == 0)
			return o0;
		int length = o0.length + o1.length;
		String[] o = new String[length];
		System.arraycopy(o0, 0, o, 0, o0.length);
		System.arraycopy(o1, 0, o, o0.length, o1.length);
		return o;
	}

	public static Object[][] unionArrays(Object[][] o0, Object[][] o1) {
		if (o0 == null && o1 == null)
			return null;
		else if (o0 == null || o0.length == 0)
			return o1;
		else if (o1 == null || o1.length == 0)
			return o0;
		else if (o0[0].length != o1[0].length)
			throw new IllegalArgumentException("Columns not match.");
		int rows = o0.length + o1.length;
		int cols = o0[0].length;
		Object[][] o = new Object[rows][cols];
		for (int j = 0; j < cols; ++j) {
			for (int i = 0; i < o0.length; ++i) {
				o[i][j] = o0[i][j];
			}
			for (int i = 0; i < o1.length; ++i) {
				o[i + o0.length][j] = o1[i][j];
			}
		}
		return o;
	}

	public static Object[][] joinArrays(Object[][] o0, Object[][] o1) {
		if (o0 == null && o1 == null)
			return null;
		else if (o0 == null || o0.length == 0)
			return o1;
		else if (o1 == null || o1.length == 0)
			return o0;
		else if (o0.length != o1.length)
			throw new IllegalArgumentException("Rows not match.");
		int rows = o0.length;
		int cols = o0[0].length + o1[1].length;
		Object[][] o = new Object[rows][cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < o0[0].length; ++j) {
				o[i][j] = o0[i][j];
			}
			for (int j = 0; j < o1[0].length; ++j) {
				o[i][j + o0[0].length] = o1[i][j];
			}
		}
		return o;
	}

	public static String getConditions(String[] conditions) {
		if (conditions == null) {
			conditions = new String[0];
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" 1=1 ");
		for (int i = 0; i < conditions.length; ++i) {
			if (conditions[i] != null && !conditions[i].trim().equals("")) {
				try {
					sb.append("and " + iso2gbk(conditions[i]) + " ");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Functionaility: get a condition arry as {"cond1='3'","cond2 = '50'"};
	 * return the value of the provided conditionName
	 * 
	 * @param conditions
	 * @param conditionName
	 * @return condValue
	 */
	public static String getConditionValue(String[] conditions,
			String conditionName) {
		String condValue = "";
		boolean isFound = false;
		if (conditions == null || conditionName.length() == 0)
			return "";

		// loop the conditions array, get the value which equal to conditionName
		for (int i = 0; i < conditions.length; ++i) {
			int index = conditions[i].indexOf(conditionName);
			if (index != -1) {
				int startIndex = conditions[i].indexOf("'");
				int endIndex = conditions[i].lastIndexOf("'");

				// the condition must contain "=", at the same time is not "!="
				boolean equalSign = (conditions[i].indexOf("=") != -1)
						&& (conditions[i].indexOf("!=") == -1);

				// do not allow same condition appear twice
				if (startIndex != -1 && isFound)
					return "";

				// find the value
				if (startIndex != -1 && equalSign) {
					condValue = conditions[i].substring(startIndex + 1,
							endIndex).trim();
					// System.out.println("the value is:" + condValue);
					isFound = true;
				}

			}// if
		}// for
		// System.out.println("\nthe last value is:" + condValue);
		return condValue;
	}

	public static String getGetterName(String s) {
		char c = s.charAt(0);
		if (c >= 'a' && c <= 'z') {
			c -= 32;
			return new StringBuffer("get").append(c).append(s.substring(1))
					.toString();
		} else {
			return new StringBuffer("get").append(s).toString();
		}
	}

	public static String getSetterName(String s) {
		char c = s.charAt(0);
		if (c >= 'a' && c <= 'z') {
			c -= 32;
			return new StringBuffer("set").append(c).append(s.substring(1))
					.toString();
		} else {
			return new StringBuffer("set").append(s).toString();
		}
	}

	public static String formatNumber(String pattern, Number n) {
		NumberFormat numFormatter = new DecimalFormat(pattern);
		return numFormatter.format(n);
	}

	public static String formatDate(long l) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date(l));
	}

	public static String getFileUploadFormParameter(final List items,
			String name) throws FileUploadException {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (!item.isFormField())
				continue;
			String fieldName = item.getFieldName();
			if (fieldName.equals(name)) {
				return item.getString();
			}
		}
		return null;
	}

	public static long bitSequence2Int(String[] bitSequence) {
		long sum = 0;
		for (int i = 0; i < bitSequence.length; ++i) {
			sum += Integer.parseInt(bitSequence[i]);
		}
		return sum;
	}

	public static String[] Int2BitSequence(long sum, int limit) {
		List list = new ArrayList();
		for (int i = 0; i < limit; ++i) {
			if (((sum >> i) & 0x1) == 1)
				list.add(String.valueOf((int) Math.pow(2, i)));
		}
		return (String[]) list.toArray(new String[0]);
	}

	public static String[] Int2BitPosition(long sum, int limit) {
		List list = new ArrayList();
		for (int i = 0; i < limit; ++i) {
			if (((sum >> i) & 0x1) == 1)
				list.add(String.valueOf(i));
		}
		return (String[]) list.toArray(new String[0]);
	}

	public static void printArray(Object[] o) {
		if (o.length == 0)
			System.out.println("empty");
		for (int i = 0; i < o.length; ++i) {
			System.out.println(i + ": " + o[i]);
		}
	}

	public static void printArray(byte[] b) {
		if (b.length == 0)
			System.out.println("empty");
		for (int i = 0; i < b.length; ++i) {
			System.out.print(Integer.toHexString(b[i]) + ",");
		}
	}

	private static int getIndex(byte[] src, byte[] target, int searchFrom) {
		outer: for (int i = searchFrom; i < src.length - target.length + 1; ++i) {
			for (int j = 0; j < target.length; ++j) {
				if (src[i + j] != target[j])
					continue outer;
			}
			return i;
		}
		return -1;
	}

	/**
	 * returns bytes of data from begin to end.
	 * 
	 * @param data
	 * @param begin
	 * @param end
	 * @param searchFrom
	 * @return
	 */
	public static byte[] cut(byte[] data, byte[] begin, byte[] end,
			int searchFrom) {
		int beginIndex = begin.length == 0 ? searchFrom : getIndex(data, begin,
				searchFrom);
		int endIndex = end.length == 0 ? data.length : getIndex(data, end,
				beginIndex + begin.length);
		if (beginIndex == -1 || endIndex == -1)
			return new byte[0];
		int length = endIndex - beginIndex - begin.length;
		byte[] b = new byte[length];
		System.arraycopy(data, beginIndex + begin.length, b, 0, length);
		return b;
	}

	public static byte[] cutAll(byte[] data, byte[] begin, byte[] end) {
		return cutAll(data, begin, end, 0);
	}

	public static byte[] cutAll(byte[] data, byte[] begin, byte[] end,
			int searchFrom) {
		List list = new ArrayList();
		for (int beginIndex = 0, endIndex = 0;; searchFrom = endIndex
				+ end.length) {
			beginIndex = begin.length == 0 ? searchFrom : getIndex(data, begin,
					searchFrom);
			endIndex = end.length == 0 ? data.length : getIndex(data, end,
					beginIndex + begin.length);
			if (beginIndex == -1 || endIndex == -1)
				break;
			int length = endIndex - beginIndex - begin.length;
			byte[] b = new byte[length];
			System.arraycopy(data, beginIndex + begin.length, b, 0, length);
			list.add(b);
			if (begin.length == 0 && end.length == 0)
				return b;
		}
		int size = 0;
		for (int i = 0; i < list.size(); ++i) {
			byte[] bi = (byte[]) list.get(i);
			size += bi.length;
		}
		byte[] b = new byte[size];
		for (int i = 0, pos = 0; i < list.size(); ++i) {
			byte[] bi = (byte[]) list.get(i);
			System.arraycopy(bi, 0, b, pos, bi.length);
			pos += bi.length;
		}
		return b;
	}

	public static byte[] cut1(byte[] data, byte[] begin, byte[] end,
			int searchFrom) throws Exception {
		String s = new String(data, "ISO-8859-1");
		int beginIndex = s.indexOf(new String(begin, "ISO-8859-1"), searchFrom);
		int endIndex = s.indexOf(new String(end, "ISO-8859-1"), searchFrom);
		int length = endIndex - beginIndex - begin.length;
		byte[] b = new byte[length];
		System.arraycopy(data, beginIndex + begin.length, b, 0, length);
		return b;
	}

	public static String empty2Null(String s) {
		if (s != null && s.length() == 0)
			s = null;
		return s;

	}

	public static void main(String[] args) throws Exception {
		String filename = "D:/eclipse3.1/workspace/EPolicyDemo/dbconn/reports/temp/";
		filename += "2006_03_22_17_33_7801.pdf";
		byte[] f = FileUtils.readFileToByteArray(new File(filename));
		byte[] b = cutAll(f, "stream".getBytes(), "endstream".getBytes(), 0);
		System.out.println(getMD5(b));
	}
}