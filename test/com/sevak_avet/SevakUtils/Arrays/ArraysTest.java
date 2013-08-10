package com.sevak_avet.SevakUtils.Arrays;

import static com.sevak_avet.SevakUtils.ArrayProcessing.shift;
import static org.junit.Assert.*;

import org.junit.Test;

import com.sevak_avet.SevakUtils.Shift;

public class ArraysTest {
	
	int[][] array = {{ 1, 2, 3, 4 }, 
					 { 5, 6, 7, 8 },
					 { 9, 10, 11, 12 },
					 { 13, 14, 15, 16}};

	@Test
	public void testArrayShiftLeft() {
		int[][] newArray = shift(array, Shift.LEFT, 1);
		int[][] test = {{2, 3, 4, 1}, 
				 { 6, 7, 8, 5 },
				 { 10, 11, 12, 9 },
				 { 14, 15, 16, 13}};
		
		assertArrayEquals(test, newArray);
	}
	
	@Test
	public void testArrayShiftRight() {
		int[][] newArray = shift(array, Shift.RIGHT, 1);
		int[][] test = {{ 4, 1, 2, 3 }, 
				 { 8, 5, 6, 7},
				 { 12, 9, 10, 11 },
				 { 16, 13, 14, 15}};
		
		assertArrayEquals(test, newArray);
	}
	
	@Test
	public void testArrayShiftUp() {
		int[][] newArray = shift(array, Shift.UP, 1);
		int[][] test = {{ 5, 6, 7, 8 },
		 		  { 9, 10, 11, 12 },
		 		  { 13, 14, 15, 16},
		 		  { 1, 2, 3, 4 }};
		
		assertArrayEquals(test, newArray);
	}
	
	@Test
	public void testArrayShiftDown() {
		int[][] newArray = shift(array, Shift.DOWN, 1);
		int[][] test = {{ 13, 14, 15, 16},
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }};
		
		assertArrayEquals(test, newArray);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testArrayShiftThrow() {
		int[][] newArray = shift(array, Shift.LEFT, -1);
	}
}
