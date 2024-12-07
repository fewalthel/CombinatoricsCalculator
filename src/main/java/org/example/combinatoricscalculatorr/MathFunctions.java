package org.example.combinatoricscalculatorr;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;

import static java.lang.StrictMath.pow;

public class MathFunctions {

    public static BigInteger getFactorial(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static BigInteger Arrangements(Boolean repeats, int n, int k) {
        if (repeats) {
            return BigInteger.valueOf((long) pow(n, k));
        } else {
            return getFactorial(n).divide(getFactorial(n - k));
        }
    }

    public static BigInteger Combinations(Boolean repeats, int n, int k) {

        if (repeats) {
            return getFactorial(n + k - 1).divide(getFactorial(k).multiply(getFactorial(n - 1)));
        } else {
            return getFactorial(n).divide(getFactorial(k).multiply(getFactorial(n - k)));
        }
    }

    public static BigInteger Permutations(int n, List<Integer> permutations) {
        BigInteger res = BigInteger.ONE;
        for (Integer x : permutations) {
            res = res.multiply(getFactorial(x));
        }
        return getFactorial(n).divide(res);
    }

    public static BigInteger Permutations(Boolean repeats, int n, int k) {
        return getFactorial(n);
    }

    /*public static BigInteger getPermutations(int n, List<Integer> permutations) {
        BigInteger res = BigInteger.ONE;
        for (Integer x : permutations) {
            res = res.multiply(getFactorial(x));
        }
        return getFactorial(n).divide(res);
    }*/

    /* public static double getUrnModel(int n, int m, int k) {
         double x = Combinations(m, k, false).doubleValue();
         double y = Combinations(n, k, false).doubleValue();
         return x / y;
     }
 */
    public static double UrnModel(int n, int m, int k, int r) {
        double x = Combinations(false, m, r).doubleValue();
        System.out.println(x);
        double y = Combinations(false, n - m, k - r).doubleValue();
        System.out.println(y);
        double z = Combinations(false, n, k).doubleValue();
        System.out.println(z);
        return (x * y) / z;
    }
}











    /*public static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long Arrangements(boolean repeat, long n, long k) {
        long result;
        if (repeat) {
            result = (long) Math.pow(n, k);
        } else {
            result = factorial(n)/factorial(n-k);
        }
        return result;
    }

    public static long Permutations(boolean repeat, long n, long k) {
        long result = 666;
        if (repeat) {

        } else {
            result = factorial(n);
        }
        return result;
    }

  */
