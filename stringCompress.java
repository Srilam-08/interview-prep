public class Main {

    // Compresses the character array in-place
    public static int compress(char[] chars) {

        int write = 0;  // index to write compressed result
        int i = 0;      // index to read characters

        while (i < chars.length) {
            char current = chars[i];
            int count = 0;

            // Count repeating characters
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write the count if greater than 1
            if (count > 1) {
                String num = String.valueOf(count);
                for (char c : num.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }

    // Main method to run and test
    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c'};

        int length = compress(chars);

        System.out.println("Compressed Length: " + length);
        System.out.print("Compressed Array: ");

        for (int i = 0; i < length; i++) {
            System.out.print(chars[i]);
        }
    }
}
