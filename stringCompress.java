public class Main {

    // Compresses the character array in-place
    public static int compress(char[] chars) {
        int write = 0;
        int read = 0;
        while(read<chars.length) {
            char current = chars[read];
            int count = 1;
            read++;
            while(read<chars.length && chars[read] == current) {
                read++;
                count++;
            }
            chars[write++] = current;

            if(count>1) {
                String num = String.valueOf(count);
                for(char c: num.toCharArray()){
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
/*
⏱️ Time Complexity
O(n)
n = length of chars
Each character is:
read once by the read pointer
written at most once by the write pointer
Inner while loop does not cause extra work overall because read only moves forward
👉 This is a classic two-pointer linear scan
💾 Space Complexity
O(1) (Constant Space)
Compression is done in-place
Only a few integer variables (read, write, count)
Temporary string for count has max length = log₁₀(n) → constant for constraints
*/
