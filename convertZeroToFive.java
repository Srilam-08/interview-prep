public class Main {

    // Reverse a number
    static int reverseNumber(int num) {
        int result = 0;
        while (num > 0) {
            int digit = num % 10;
            result = result * 10 + digit;
            num /= 10;
        }
        return result;
    }

    // Convert all 0s in a number to 5s
    static int convert0To5(int num) {
        if (num == 0) return 5;

        int temp = 0;

        while (num > 0) {
            int digit = num % 10;

            // Replace 0 with 5
            if (digit == 0) digit = 5;

            temp = temp * 10 + digit;
            num /= 10;
        }

        // Reverse the temp to restore original order
        return reverseNumber(temp);
    }

    public static void main(String[] args) {
        int num = 10120;
        System.out.println("Original Number: " + num);
        System.out.println("After Conversion: " + convert0To5(num));
    }
}
