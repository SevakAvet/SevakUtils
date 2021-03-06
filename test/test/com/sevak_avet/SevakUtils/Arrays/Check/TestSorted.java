package test.com.sevak_avet.SevakUtils.Arrays.Check;

import static com.sevak_avet.SevakUtils.Arrays.Check.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSorted {
	int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int[] b = { 5, 2, 3, 6, 5, 4, 8 };
	int[] c = { 5, 4, 3, 2, 1 };

	@Test
	public void testCheckSorted() {
		assertEquals(true, isSorted(a, false));
		assertEquals(false, isSorted(b, false));
		assertEquals(true, isSorted(c, true));
	}
}
