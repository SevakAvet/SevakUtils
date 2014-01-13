package com.sevak_avet.SevakUtils.Maths;

import static java.lang.Math.abs;
import java.util.HashMap;

/**
 * @author Sevak Avetisyan
 * @since 09.11.13
 * */

public class Polynomial {
	private double[] coeff;
	private Polynomial original = null;
	private PolynomTerm[] polynomial;
	private int derrivativeCount = 0;

	private PolynomTerm[] getPolynomTerms() {
		return polynomial;
	}

	/**
	 * @return Original polynomial
	 */
	public Polynomial getOriginal() {
		if (original != null) {
			return original;
		}

		original = new Polynomial(coeff);
		return original;
	}

	/**
	 * Creating new polynomial from its coefficients
	 * 
	 * @param coeff
	 *            Polynomial coefficients (0-indexed)
	 */
	public Polynomial(double... coeff) {
		this.coeff = coeff;
		int size = coeff.length;
		polynomial = new PolynomTerm[size];

		for (int i = 0; i < size; ++i) {
			polynomial[i] = new PolynomTerm(coeff[i], size - i - 1);
		}
	}

	public double solve(double x) {
		double res = 0;

		for (PolynomTerm p : polynomial) {
			if (p.degree >= 0) {
				res += p.coeff * Math.pow(x, p.degree);
			}
		}

		return res;
	}

	/**
	 * Calculating derivative
	 * 
	 * @param n
	 *            The order of differentiation
	 */
	public void calculateDerivative(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException(
					"Derrivative order must be positive, n = " + n);
		}

		for (int i = 0; i < n; ++i) {
			if (!calculateDerivative()) {
				break;
			}
		}
	}

	public boolean calculateDerivative() {
		if (this.toString().equals("0")) {
			return false;
		}

		++derrivativeCount;
		for (PolynomTerm m : polynomial) {
			m.coeff *= m.degree;
			m.degree -= 1;
		}

		return true;
	}

	public Polynomial mul(Polynomial y) {
		PolynomTerm[] x = y.getPolynomTerms();
		HashMap<Integer, Double> res = new HashMap<>();

		for (PolynomTerm a : polynomial) {
			for (PolynomTerm b : x) {
				int degree = a.degree + b.degree;
				double coeff = a.coeff * b.coeff;

				if (coeff != 0) {
					if (!res.containsKey(degree)) {
						res.put(degree, coeff);
					} else {
						res.put(degree, res.get(degree) + coeff);
					}
				}
			}
		}

		double[] p = new double[res.size()];
		int size = p.length;

		for (int i : res.keySet()) {
			p[size - i - 1] = res.get(i);
		}

		return new Polynomial(p);
	}

	public Polynomial add(Polynomial y) {
		PolynomTerm[] x = y.getPolynomTerms();
		HashMap<Integer, Double> res = new HashMap<>();

		int xLast = x.length - 1;
		int yLast = polynomial.length - 1;

		while (xLast >= 0 || yLast >= 0) {
			int degree = xLast >= 0 ? x[xLast].degree
					: yLast >= 0 ? polynomial[yLast].degree : -1;
			double coeff = (xLast >= 0 ? x[xLast].coeff : 0)
					+ (yLast >= 0 ? polynomial[yLast].coeff : 0);

			if (!res.containsKey(degree)) {
				res.put(degree, coeff);
			} else {
				res.put(degree, res.get(degree) + coeff);
			}

			--xLast;
			--yLast;
		}

		double[] p = new double[res.size()];
		int size = p.length;
		for (int i : res.keySet()) {
			if (i >= 0) {
				p[size - i - 1] = res.get(i);
			}
		}

		return new Polynomial(p);
	}

	public int getDerrivativeCount() {
		return derrivativeCount;
	}

	/**
	 * @return String, which contained polynomial
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		String tempString = polynomial[0].toString();
		boolean first = false;

		for (PolynomTerm m : polynomial) {
			if (!tempString.equals("")) {
				sb.append(m.coeff >= 0 ? first ? " + " : "" : first ? " - "
						: "-");
			}

			first = true;

			tempString = m.toString();
			sb.append(tempString);
		}

		int index = sb.length() - 1;
		if (index >= 0) {
			char tempChar = sb.charAt(index);
			while (tempChar == ' ' || tempChar == '+' || tempChar == '-') {
				sb.deleteCharAt(index--);
				tempChar = sb.charAt(index);
			}
		}

		return sb.toString().equals("") ? "0" : sb.toString();
	}

	private class PolynomTerm {
		double coeff;
		int degree;

		public PolynomTerm(double coeff, int degree) {
			this.coeff = coeff;
			this.degree = degree;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			if (coeff != 0) {
				if (abs(coeff) != 1) {
					sb.append(abs(coeff));
				}

				if (degree != 0) {
					if (degree != 1) {
						if (abs(coeff) != 1) {
							sb.append("*x^");
						} else {
							sb.append("x^");
						}

						sb.append(degree);
					} else {
						sb.append("x");
					}
				} else {
					if (abs(coeff) == 1) {
						sb.append(abs(coeff));
					}
				}
			}

			return sb.toString();
		}
	}

}
