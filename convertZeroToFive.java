public class Main {

    // Convert all 0s in a number to 5s
    static int convert0To5(int num) {
        if (num == 0) return 5;

        int result = 0;
        int multiplier = 1;

        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) digit = 5;

            result += digit * multiplier;
            multiplier *= 10;
            num /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        int num = 10120;
        System.out.println("Original Number: " + num);
        System.out.println("After Conversion: " + convert0To5(num)); // 15125
    }
}
