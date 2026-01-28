public class Main {

    // Iterative approach to compute digital root
    public static int digitalRoot(int n) {
        while (n >= 10) { // repeat until n is a single digit
            int sum = 0;
            int temp = n;
            while (temp > 0) {
                sum += temp % 10; // add last digit
                temp /= 10;       // remove last digit
            }
            n = sum; // replace n with sum of digits
        }
        return n;
    }

    // Mathematical O(1) approach
    public static int digitalRootFast(int n) {
        if (n == 0) return 0;
        return 1 + (n - 1) % 9; // digital root formula
    }

    public static void main(String[] args) {

        int[] nums = {16, 942, 132189, 493193};

        System.out.println("Iterative approach:");
        for (int num : nums) {
            System.out.println(num + " -> " + digitalRoot(num));
        }

        System.out.println("\nMathematical formula approach:");
        for (int num : nums) {
            System.out.println(num + " -> " + digitalRootFast(num));
        }
    }
}

/*
O(1) — Constant Time
Uses a fixed number of arithmetic operations
No loops
No recursion
Execution time is independent of the size of n
💾 Space Complexity
O(1) — Constant Space
Uses only a few integer variables
No additional data structures
No recursion stack
*/
