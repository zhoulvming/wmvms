/**
 * Dec 16, 2011
 */
package org.myplay.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author elgs
 * 
 */
public class TestRegexGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputStr = "asdf$dict_test1$sdfl$search_test2$sdf$dict_test3$sdfsa";
		printList(TestRegexGroup.catpure(inputStr, "dict"));
		printList(TestRegexGroup.catpure(inputStr, "search"));
	}

	public static List<String> catpure(String input, String type) {
		List<String> ret = new ArrayList<String>();
		Pattern pattern = Pattern.compile("(\\$" + type + "_.+?\\$)");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			String groupStr = matcher.group();
			ret.add(groupStr.substring(type.length() + 2, groupStr.length() - 1));
		}
		return ret;
	}

	public static void printList(List<String> l) {
		for (String s : l) {
			System.out.println(s);
		}
	}

}
