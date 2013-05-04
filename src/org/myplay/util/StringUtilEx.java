package org.myplay.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilEx {
	
	public static String safeReplace(String s, boolean encode) {
		if (encode) {
			return s.trim().replaceAll(" ", "__space__").replaceAll("(?<=[A-Za-z])\\.", "__dot__");
		} else {
			return s.trim().replaceAll("__space__", " ").replaceAll("__dot__", ".");
		}
	}
	
	// return a string like "f1,f2,f3,..."
	public static String getFieldsStringWithFunction(List<String> fields, Map<String, String> funFields) {
		if (fields == null) {
			fields = new ArrayList<String>();
		}
		StringBuffer sb = new StringBuffer(" ");
		for (String field : fields) {
			if (funFields.keySet().contains(field)) {
				field = funFields.get(field) + " as " + field;
			}
			sb.append(field + ",");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	// return a string like "f1,f2,f3,..."
	public static String getFieldsString(List<String> fields) {
		if (fields == null) {
			fields = new ArrayList<String>();
		}
		StringBuffer sb = new StringBuffer(" ");
		for (String field : fields) {
			if (field != null && field.trim().length() > 0) {
				sb.append("" + field + ",");
			}
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	// return a string like "?,?,?,..."
	public static String getFieldsPlaceHolderString(List<String> fields) {
		if (fields == null) {
			fields = new ArrayList<String>();
		}
		StringBuffer sb = new StringBuffer(" ");
		for (String field : fields) {
			if (field != null && field.trim().length() > 0) {
				sb.append("?,");
			}
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
	
	@SuppressWarnings("unused")
	private void printMap(Map<String, Object> m) {
		for (String key : m.keySet()) {
			System.out.print("[" + key + ":" + m.get(key) + "]");
		}
		System.out.println();
	}
	
	public static List<String> capture(String input, String type) {
		List<String> ret = new ArrayList<String>();
		Pattern pattern = Pattern.compile("(\\$" + type + "_.+?\\$)");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			String groupStr = matcher.group();
			ret.add(groupStr.substring(type.length() + 2, groupStr.length() - 1));
		}
		return ret;
	}
	
	/**
	 * 修改指定位置字符为大写或小写
	 * 
	 * @param src
	 *            源字符串
	 * @param index
	 *            指定的字符串位置 如果大于字符串长度 则返回字符串 index大于0
	 * 
	 * 
	 * @return 字符串，将src的某一个字母转换为大写，src为空时返回空
	 */
	public static String charChange(String src, boolean upper, int index) {
		if (null == src)
			return "";
		if ("".equals(src.trim()))
			return "";
		if (src.length() <= index)
			return src;
		index = index - 1;
		StringBuffer sb = new StringBuffer(src);
		sb.setCharAt(index, upper ? Character.toUpperCase(sb.charAt(index)) : Character.toLowerCase(sb.charAt(index)));
		return sb.toString();
		
	}
	
	/**
	 * 
	 * @param src
	 * @param index
	 * @param fc
	 * 
	 * @return
	 */
	public static String fillChar(String src, int index, String fc) {
		StringBuffer buffer = new StringBuffer();
		if (index > 0 && index < src.length()) {
			buffer.append(src.substring(0, index));
			buffer.append(fc);
			buffer.append(src.substring(index));
		} else {
			buffer.append(src).append(fc);
		}
		return buffer.toString();
	}
	
	public static List<String> splitWords(String str) {
		if (str == null)
			return null;
		boolean b = false;
		
		int indexStart = 0;
		int indexStop = 0;
		int idx = 0;
		str += " ";
		List<String> list = new ArrayList<String>();
		
		while (idx < str.length()) {
			if ((str.charAt(idx) >= 'A' && str.charAt(0) <= 'Z') || (str.charAt(idx) >= 'a' && str.charAt(0) <= 'z')) {
				if (!b) {
					indexStart = idx;
					if (indexStart != indexStop) {
						String ret = str.substring(indexStop, indexStart);
						list.add(ret);
					}
					b = true;
				}
				idx++;
			} else {
				if (b) {
					indexStop = idx;
					String ret = str.substring(indexStart, indexStop);
					list.add(ret);
					b = false;
				}
				idx++;
			}
		}
		return list;
	}
	
	// 98%Sliver2%CTN -> 98, %, Sliver, 2, %, CTN
	public static List<String> splitWordsCn(String words) {
		List<String> list = new ArrayList<String>();
		int lastType = -1;
		int type = 0;
		String ret = "";
		for (int i = 0; i < words.length(); i++) {
			char c = words.charAt(i);
			if (c == ' ')
				continue;
			if (c >= '0' && c <= '9')
				type = 0;
			else if (c == '%')
				type = 1;
			else
				type = 2;
			if (type == lastType) {
				ret += c;
			} else {
				if (ret != null && !"".equals(ret))
					list.add(ret);
				ret = String.valueOf(c);
			}
			lastType = type;
		}
		if (ret != null && !"".equals(ret))
			list.add(ret);
		return list;
	}
	
	// 去掉数字后面多余的0
	public static String subZeroAndDot(String s) {
		if (s == null)
			return null;
		if (s.indexOf(".") > 0) {
			s = s.replaceAll("0+?$", "");// 去掉多余的0
			s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
		}
		return s;
	}
	
	public final static String MD5(String strs) {
		
		byte[] strTemp = {};
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			
			strTemp = strs.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		// splitWords("This a test");
		// splitWordsCn("98%棉花2%丝");
		// splitWordsCn("98%Sliver2%CTN");
		// System.out.println(safeReplace("A.FFF60.93", true));
		// String str = "853649001";
		// System.out.println(fillChar(str, "85364900".length() + 2, "00"));
		// String str = "p.PO_NO,p.HS_CODE,y.`NAME`,z.`NAME`";
		
		// String reg = "([A-Za-z]\\.)";
		// if (str.matches(reg))
		// System.out.println(str.replaceAll(reg, ""));
		
		// System.out.println(MD5(new String[] { "123456" }).length());
	}
	
}
