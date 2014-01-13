package test.com.sevak_avet.SevakUtils.Arrays.Modify;

import static com.sevak_avet.SevakUtils.Arrays.Modify.turn;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.sevak_avet.SevakUtils.Arrays.Enums.Turn;

public class TestRotate {
	int[][] test = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

	String[][] testObject = { { "A", "B", "C" }, { "D", "E", "F" },
			{ "G", "H", "I" } };

	@Test
	public void testArrayRotateRight() {
		int[][] expected = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };

		int[][] newArr = turn(test, Turn.RIGHT);

		assertArrayEquals(expected, newArr);
	}

	@Test
	public void testArrayRotateLeft() {
		int[][] expected = { { 3, 6, 9 }, { 2, 5, 8 }, { 1, 4, 7 } };

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

		assertArrayEquals(test, newArr);
	}

	@Test
	public void testTurnRightFour() {
		int[][] newArr = turn(test, Turn.RIGHT);
		newArr = turn(newArr, Turn.RIGHT);
		newArr = turn(newArr, Turn.RIGHT);
		newArr = turn(newArr, Turn.RIGHT);

		assertArrayEquals(test, newArr);
	}
}
