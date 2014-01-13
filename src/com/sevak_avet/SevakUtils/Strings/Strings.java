package com.sevak_avet.SevakUtils.Strings;

public class Strings {
	public static boolean isPolyndrom(String s) {
		for (int i = 0; i < s.length() / 2; ++i) {
			if (s.charAt(i) != s.charAt(s.length() - i)) {
				return false;
			}
		}

		return true;
	}
}
