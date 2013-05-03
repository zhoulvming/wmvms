/**
 * Dec 20, 2011
 */
package org.myplay.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author elgs
 * 
 */
public class TestAnalyzer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "98% COTTON 2%ELASTANE";
		String s1 = "YACKI,XX,JL,NICHY&TYY";
		TestAnalyzer.printList(TestAnalyzer.splitWords(s));
	}

	public static void printList(List<String> l) {
		for (String s : l) {
			System.out.println("#:" + s);
		}
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
						// System.out.println(ret);
						list.add(ret);
					}
					b = true;
				}
				idx++;
			} else {
				if (b) {
					indexStop = idx;
					String ret = str.substring(indexStart, indexStop);
					// System.out.println(ret);
					list.add(ret);
					b = false;
				}
				idx++;
			}
		}

		return list;
	}
}
