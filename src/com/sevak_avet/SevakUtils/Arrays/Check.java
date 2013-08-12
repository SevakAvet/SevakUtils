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
		
		for(int i=0; i<a.length; ++i) {
			if(a[i] != newA[i]) {
				return false;
			}
		}
		
		return true;
	}
}
