package com.sevak_avet.SevakUtils;

import java.util.Arrays;


public class ArrayProcessing {
	
	public static int[][] shift(int[][] originalArr, Shift shift, int howMuch) {
		if(howMuch < 0) {
			throw new IllegalArgumentException("Shift size must be not null!");
		}
		
		int column = originalArr[0].length;
		int row = originalArr.length;

		int[][] newArr = new int[row][column];	

		if(shift == Shift.LEFT || shift == Shift.RIGHT) {
			howMuch %= column;
		} else {
			howMuch %= row;
		}
		
		if(howMuch == 0) {
			return originalArr;
		}
		
		switch (shift) {
		case LEFT:
			for (int i=0; i<originalArr.length; ++i) {
				System.arraycopy(originalArr[i], howMuch, newArr[i], 0, originalArr[i].length - howMuch);
				System.arraycopy(originalArr[i], 0, newArr[i], originalArr[i].length - howMuch, howMuch);
			}
			
			break;

		case RIGHT:			
			for (int i=0; i<originalArr.length; ++i) {
				System.arraycopy(originalArr[i], originalArr[i].length - howMuch, newArr[i], 0, howMuch);
				System.arraycopy(originalArr[i], 0, newArr[i], howMuch, originalArr[i].length - howMuch);
			}
			
			break;

		case UP:			
			for(int i=0; i<howMuch; ++i) {
				newArr[originalArr.length - howMuch + i] = Arrays.copyOf(originalArr[i], originalArr[i].length);
			}
			
			for(int i=howMuch; i<originalArr.length; ++i) {
				newArr[i - howMuch] = Arrays.copyOf(originalArr[i], originalArr[i].length);
			}
			
			break;

		case DOWN:			
			for(int i=0; i<originalArr.length - howMuch; ++i) {
				newArr[i + howMuch] = Arrays.copyOf(originalArr[i], originalArr[i].length);
			}
			
			for(int i = originalArr.length - howMuch; i<originalArr.length; ++i) {
				newArr[i - originalArr.length + howMuch] = Arrays.copyOf(originalArr[i], originalArr[i].length);
			}
			
			break;
		}

		return newArr;
	}
}
