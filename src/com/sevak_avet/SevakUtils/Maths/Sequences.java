package com.sevak_avet.SevakUtils.Maths;

public class Sequences {
	public static long fibbonachi(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			long x = 1;
			long xBigger = 1;
			long rez = 0;

			for (int i = 3; i <= n; ++i) {
				rez = x + xBigger;
				x = xBigger;
				xBigger = rez;
			}

			return rez;
		}
	}
}
