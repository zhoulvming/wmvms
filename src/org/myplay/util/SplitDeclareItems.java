package org.myplay.util;

public class SplitDeclareItems {

	public static String src = "1、品名:断路器；2、用途：电力系统的控制和保护装置，控制电气设备的输出功率，在异常情况中保护电气设备和人不受损（伤）害；3、品牌:GE；4、型号:AEG系列；5、额定电压:<1000V";

	public static void main(String[] args) {
		SplitDeclareItems sdi = new SplitDeclareItems();
		sdi.getResult(src);
	}

	public String getResult(String src) {
		//String ret = QBchange(src);
		src = src.replaceAll("1、", "1.\r\n");
		src = src.replaceAll("2、", "\r\n2.\r\n");
		src = src.replaceAll("3、", "\r\n3.\r\n");
		src = src.replaceAll("4、", "\r\n4.\r\n");
		src = src.replaceAll("5、", "\r\n5.\r\n");
		src = src.replaceAll("6、", "\r\n6.\r\n");
		src = src.replaceAll("7、", "\r\n7.\r\n");
		src = src.replaceAll("8、", "\r\n8.\r\n");
		src = src.replaceAll("；", ";");
		src = src.replaceAll("：", ":");

		String ret[] = src.split("\r\n");
		int p = 0;
		int start = 0;

		for (int i = 0; i < ret.length; i++)
			clearRet(ret[i]);

		System.out.println(src);
		return src;
	}

	private void clearRet(String string) {
		int i = 0;
		int switcher = 0;
		while (i < string.length() - 1) {
			String code = string.substring(i, i + 1);

			if (string.length()==2 && code.charAt(0) <= 65)
				break;

			if (code.getBytes().length == 1)
				switcher++;

			if (switcher == 1) {
				System.out.println(string.substring(i+1).trim() + ";");
				break;
			}
			i++;
		}
	}

}
