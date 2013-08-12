package com.sevak_avet.SevakUtils.Arrays;

import java.util.Arrays;

public class Check {

	public static boolean isSorted(int[] a) {
		int[] newA = Arrays.copyOf(a, a.length);
		Arrays.sort(newA);

		return Arrays.equals(a, newA);
	}

	public static boolean isSorted2(int[] a) {
		int[] newA = Arrays.copyOf(a, a.length);
		Arrays.sort(newA);

		for (int i = 0; i < a.length; ++i) {
			if (a[i] != newA[i]) {
				return false;
			}
		}

		return true;
	}

	public static boolean isSorted(int[] a, boolean reversed) {
		if (reversed == false) {
			for (int i = 0; i < a.length - 1; ++i) {
				if (a[i] > a[i + 1]) {
					return false;
				}
			}
		} else {
			for (int i = 0; i < a.length - 1; ++i) {
				if (a[i] < a[i + 1]) {
					return false;
				}
			}
		}

		return true;
	}
}
