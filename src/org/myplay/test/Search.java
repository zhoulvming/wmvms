package org.myplay.test;

import java.util.HashMap;

public class Search {

	private static HashMap<String, String> map = new HashMap<String, String>();
	private static HashMap<String, String> map2 = new HashMap<String, String>();
	static {
		map.put("CN", "中国");
		map.put("US", "美国");
	}

	static {
		map2.put("key", "value1");
		map2.put("key2", "US");
	}

	public static String searchCountry(String cty) {
		return map.get(cty);
	}

	public static String getProp(String cty) {
		return map2.get(cty);
	}
}
