class Solution {
    public double myPow(double x, int n) {
        // double result = 1.0;
        // if (n > 0) {
        //     while (n > 0) {
        //         result *= x;
        //         n--;
        //     }

        // } else {
        //     while (n < 0) {
        //         result /= x;
        //         n++;
        //     }
        // }

        //     return result;


//most useful approach for larger n value
// Use long to prevent integer overflow when handling Integer.MIN_VALUE
        // Cast to long immediately to prevent the -Integer.MIN_VALUE overflow bug
        long N = n;
        
        // Handle negative exponents
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
        // Base cases
        if (n == 0) return 1.0;
        if (n == 1) return x;
        
        // Divide and conquer: calculate half power once
        double half = fastPow(x, n / 2);
        
        // Combine results
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
    }
