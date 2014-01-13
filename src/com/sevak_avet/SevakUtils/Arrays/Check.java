package com.sevak_avet.SevakUtils.Arrays;

import java.util.Arrays;

public class Check {

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

	public static boolean isSorted(long[] a, boolean reversed) {
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

	public static boolean isSorted(double[] a, boolean reversed) {
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

	public static <T extends Comparable<T>> boolean isSorted(T[] a,
			boolean reversed) {
		if (reversed == false) {
			for (int i = 0; i < a.length - 1; ++i) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					return false;
				}
			}
		} else {
			for (int i = 0; i < a.length - 1; ++i) {
				if (a[i].compareTo(a[i + 1]) < 0) {
					return false;
				}
			}
		}

		return true;
	}

	/*
	 * public static int count(int[] a, int number) { return (int)
	 * Arrays.stream(a).filter(x -> x == number).count(); }
	 * 
	 * public static int count(long[] a, long number) { return (int)
	 * Arrays.stream(a).filter(x -> x == number).count(); }
	 * 
	 * public static int count(double[] a, double number) { return (int)
	 * Arrays.stream(a).filter(x -> x == number).count(); }
	 * 
	 * public static <T> int count(T[] a, T number) { return (int)
	 * Arrays.stream(a).filter(x -> x.equals(number)).count(); }
	 */
}
