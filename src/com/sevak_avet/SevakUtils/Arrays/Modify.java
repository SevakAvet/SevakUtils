package com.sevak_avet.SevakUtils.Arrays;

import java.util.Arrays;

import com.sevak_avet.SevakUtils.Arrays.Enums.Shift;
import com.sevak_avet.SevakUtils.Arrays.Enums.Turn;


public class Modify {
	
	public static int[][] shift(int[][] source, Shift shift, int howMuch) {
		if(howMuch < 0) {
			throw new IllegalArgumentException("Shift size must be not null!");
		}
		
		int row = source.length;
		int column = source[0].length;

		int[][] newArr = new int[row][column];	

		if(shift == Shift.LEFT || shift == Shift.RIGHT) {
			howMuch %= column;
		} else {
			howMuch %= row;
		}
		
		if(howMuch == 0) {
			return source;
		}
		
		switch (shift) {
		case LEFT:
			for (int i=0; i<source.length; ++i) {
				System.arraycopy(source[i], howMuch, newArr[i], 0, source[i].length - howMuch);
				System.arraycopy(source[i], 0, newArr[i], source[i].length - howMuch, howMuch);
			}
			
			break;

		case RIGHT:			
			for (int i=0; i<source.length; ++i) {
				System.arraycopy(source[i], source[i].length - howMuch, newArr[i], 0, howMuch);
				System.arraycopy(source[i], 0, newArr[i], howMuch, source[i].length - howMuch);
			}
			
			break;

		case UP:			
			for(int i=0; i<howMuch; ++i) {
				newArr[source.length - howMuch + i] = Arrays.copyOf(source[i], source[i].length);
			}
			
			for(int i=howMuch; i<source.length; ++i) {
				newArr[i - howMuch] = Arrays.copyOf(source[i], source[i].length);
			}
			
			break;

		case DOWN:			
			for(int i=0; i<source.length - howMuch; ++i) {
				newArr[i + howMuch] = Arrays.copyOf(source[i], source[i].length);
			}
			
			for(int i = source.length - howMuch; i<source.length; ++i) {
				newArr[i - source.length + howMuch] = Arrays.copyOf(source[i], source[i].length);
			}
			
			break;
		}

		return newArr;
	}
	
	public static int[][] turn(int[][] source, Turn turn) {
		int row = source.length;
		int column = source[0].length;
		int currentI = 0;
		int currentJ = 0;
		
		int[][] newArr = new int[row][column];
		
		
		switch (turn) {
		case LEFT:
			for(int j=column-1; j>=0; --j) {
				for(int i=0; i<row; ++i){
					newArr[currentJ][currentI] = source[i][j];
					
					if(currentI + 1 < row) {
						++currentI;
					} else {
						currentI = 0;
						++currentJ;
					}
				}
			}
			break;

		case RIGHT:
			for(int i=0; i<row; ++i) {
				for(int j=column-1; j>=0; --j) {
					newArr[currentJ][currentI] = source[j][i];
					
					if(currentI + 1 < row) {
						++currentI;
					} else {
						currentI = 0;
						++currentJ;
					}
				}
			}
			break;
		}
		
		return newArr;
	}
}
