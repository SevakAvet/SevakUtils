package com.sevak_avet.SevakUtils.Arrays;

import static org.junit.Assert.*;
import static com.sevak_avet.SevakUtils.ArrayProcessing.*;

import org.junit.Test;
import com.sevak_avet.SevakUtils.Turn;

public class ArrayTestRotate {
	int[][] test = {{ 1, 2, 3 },
					{ 4, 5, 6 },
					{ 7, 8, 9 }};
	
	
	@Test
	public void testArrayRotateRight() {
		int[][] expected = {{7,4,1},
							{8,5,2},
							{9,6,3}};
		
		int[][] newArr = turn(test, Turn.RIGHT);
		
		assertArrayEquals(expected, newArr);
	}
	
	@Test
	public void testArrayRotateLeft() {
		int[][] expected = {{3,6,9},
							{2,5,8},
							{1,4,7}};
		
		int[][] newArr = turn(test, Turn.LEFT);		
		assertArrayEquals(expected, newArr);
	}
	
	@Test
	public void testTurnLeftRight() {
		int[][] newArr = turn(test, Turn.LEFT);
		newArr = turn(newArr, Turn.RIGHT);
		assertArrayEquals(test, newArr);	
	}
	
	@Test
	public void testTurnLeftFour() {
		int[][] newArr = turn(test, Turn.LEFT);
		newArr = turn(newArr, Turn.LEFT);
		newArr = turn(newArr, Turn.LEFT);
		newArr = turn(newArr, Turn.LEFT);
		
		assertEquals(test, newArr);
	}
	
	@Test
	public void testTurnRightFour() {
		int[][] newArr = turn(test, Turn.RIGHT);
		newArr = turn(newArr, Turn.RIGHT);
		newArr = turn(newArr, Turn.RIGHT);
		newArr = turn(newArr, Turn.RIGHT);
		
		assertEquals(test, newArr);
	}
}
