package org.myplay.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaterialCalc {

	class Content {
		Integer percent;
		String name;

	}

	class ContentCompare implements Comparator {

		public int compare(Object arg0, Object arg1) {
			Content c0 = (Content) arg0;
			Content c1 = (Content) arg1;
			int flag = c1.percent.compareTo(c0.percent);
			return flag;
		}

	}

	@SuppressWarnings("unchecked")
	public String sortMaterial(List<String> src) {

		int sigFound = 0;
		List<Content> contents = new ArrayList<Content>();
		Content ctt = new Content();
		for (String o : src) {
			if (o == null || "".equals(o))
				continue;
			// 数字
			if (o.charAt(0) >= '0' && o.charAt(0) <= '9') {
				Integer i = Integer.parseInt(o);
				sigFound++;
				ctt.percent = i;
				if (sigFound == 2) {
					contents.add(ctt);
					ctt = new Content();
					sigFound = 0;
				}

			} else if (o.charAt(0) == '%')
				continue;
			else {
				sigFound++;
				ctt.name = o;
				if (sigFound == 2) {
					contents.add(ctt);
					ctt = new Content();
					sigFound = 0;
				}

				continue;
			}
		}

		ContentCompare comp = new ContentCompare();
		Collections.sort(contents, comp);
		return null;
	}

}
