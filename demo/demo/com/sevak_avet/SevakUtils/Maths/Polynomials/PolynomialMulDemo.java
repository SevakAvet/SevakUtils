package demo.com.sevak_avet.SevakUtils.Maths.Polynomials;

import com.sevak_avet.SevakUtils.Maths.Polynomial;

public class PolynomialMulDemo {
	public static void main(String[] args) {
		Polynomial a = new Polynomial(-1, 0, 1);
		System.out.println(a);

		Polynomial b = new Polynomial(-1, -1, 1);
		System.out.println(b);

		System.out.println(a.mul(b));
	}
}
