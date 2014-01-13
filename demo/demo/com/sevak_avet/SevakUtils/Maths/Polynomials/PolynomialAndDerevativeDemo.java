package demo.com.sevak_avet.SevakUtils.Maths.Polynomials;

import com.sevak_avet.SevakUtils.Maths.Polynomial;

public class PolynomialAndDerevativeDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Polynomial a = new Polynomial(1, 1, 1, 1);
		Polynomial original = a.getOriginal();

		a.calculateDerivative(1);

		System.out.printf("Original polynome: %s\n", original.toString());
		System.out.printf("1-rd derevative: %s\n", a.toString());
		System.out.printf("\nMultiplyed: %s", a.mul(original));

	}
}
