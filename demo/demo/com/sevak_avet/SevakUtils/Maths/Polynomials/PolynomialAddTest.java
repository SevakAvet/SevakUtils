package demo.com.sevak_avet.SevakUtils.Maths.Polynomials;

import com.sevak_avet.SevakUtils.Maths.Polynomial;

public class PolynomialAddTest {
	public static void main(String[] args) {
		System.out.println(getTangent(new Polynomial(1, 0, 0), 3));
	}

	public static Polynomial getTangent(Polynomial f, double x0) {
		Polynomial a = new Polynomial(f.solve(x0));

		f.calculateDerivative();
		Polynomial b = new Polynomial(f.solve(x0));

		Polynomial c = new Polynomial(1, -x0);
		Polynomial res = b.mul(c).add(a);

		return res;
	}
}
