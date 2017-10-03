package com.reactive.venkat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToDelete {

	public static void main(String[] args) {
		String s = "{SS2015|false|false|X}{FW2015|false|false|B}{SS2016|false|false|B}{FW2016|false|false|X}{SS2017|false|false|X}{FW2017|false|false|X}{SS2018|false|false|X}{FW2018|false|false|X}";

		System.out.println(sss(s));
	}

	private static String sss(String s) {
		Pattern p = Pattern.compile("\\{FW2017\\|false\\|false\\|(.*?)\\}"); 
		Matcher m = p.matcher(s);
		String theGroup = null;
		if (m.find()) {
			theGroup = m.group(1);
		}
		return theGroup;
	}

}
