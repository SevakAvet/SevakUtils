package demo.com.sevak_avet.SevakUtils.Maths.Polynomials;


import com.sevak_avet.SevakUtils.Maths.Polynomial;

/**
 * Demo class, calculate derivative, while it's not 0
 */

public class DerivativeDemo {
	public static void main(String[] args) {
		Polynomial d = new Polynomial(1.0, 1, 1, 1);
		System.out.printf("Original polynominal: %s\n", d);

		System.out.println(d.getDerrivativeCount());
	}
}
