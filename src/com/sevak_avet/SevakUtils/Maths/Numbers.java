package com.sevak_avet.SevakUtils.Maths;

import com.sevak_avet.SevakUtils.Strings.Strings;

public class Numbers {
	public static boolean isTwoPow(long l) {
		return l != 0 && (l & (~l + 1)) == l;
	}

	public static boolean isPolyndrom(int i) {
		return Strings.isPolyndrom(Integer.toString(i));
	}
}
