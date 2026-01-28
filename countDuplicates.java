import java.util.HashMap;
import java.util.Map;

public class Main {

    // Function to count distinct duplicates (case-insensitive)
    public static int countDuplicates(String text) {

        Map<Character, Integer> freq = new HashMap<>();

        // Convert to lowercase to ignore case
        text = text.toLowerCase();

        // Count frequency of each character
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Count how many characters occur more than once
        int count = 0;
        for (int value : freq.values()) {
            if (value > 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] tests = {
            "abcde",
            "aabbcde",
            "aabBcde",
            "indivisibility",
            "Indivisibilities",
            "aA11",
            "ABBA"
        };

        for (String test : tests) {
            System.out.println("\"" + test + "\" -> " + countDuplicates(test));
        }
    }
}
