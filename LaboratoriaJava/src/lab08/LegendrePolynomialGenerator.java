package lab08;

public class LegendrePolynomialGenerator {
	public static double getPolynomial(int n, double x) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        
        double P_n_minus_1 = x;
        double P_n_minus_2 = 1.0;
        double P_n = 0.0;

        for (int k = 2; k <= n; k++) {
            P_n = ((2 * k - 1) * x * P_n_minus_1 - (k - 1) * P_n_minus_2) / k;
            P_n_minus_2 = P_n_minus_1;
            P_n_minus_1 = P_n;
        }

        return P_n;
    }
}
