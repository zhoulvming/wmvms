package org.myplay.test;

import java.util.ArrayList;
import java.util.List;

public class TestDivide {

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
					if (indexStop != indexStart) {
						String ret = str.substring(indexStop, indexStart);
						System.out.println(ret);
						list.add(ret);
					}
					b = true;
				}
				idx++;
			} else {
				if (b) {
					indexStop = idx;
					String ret = str.substring(indexStart, indexStop);
					System.out.println(ret);
					list.add(ret);
					b = false;
				}
				idx++;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		splitWords("TEST98% COTTON2%ELASTANE");
	}
}
