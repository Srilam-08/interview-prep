public class Main {

    public static int countDuplicates(String text) {
        // Only 26 letters + 10 digits = 36 possible characters
        int[] freq = new int[36];
        int duplicates = 0;

        for (char c : text.toCharArray()) {
            int index;
            if (Character.isDigit(c)) {
                index = c - '0' + 26; // digits mapped to 26-35
            } else {
                index = Character.toLowerCase(c) - 'a'; // letters mapped to 0-25
            }

            freq[index]++;
            // Increment duplicates count **only when freq becomes 2**
            if (freq[index] == 2) duplicates++;
        }

        return duplicates;
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

/*
⏱ Complexity
Metric	Complexity
Time	O(n) → iterate through each character once
Space	O(1) → fixed-size array of 36 integers
import java.util.HashSet;
import java.util.Set;

public class CountDuplicates {
    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        Set<Character> seen = new HashSet<>();
        Set<Character> duplicates = new HashSet<>();

        for (char c : text.toCharArray()) {
            if (!seen.add(c)) {   // if already seen
                duplicates.add(c); // add to duplicates
            }
        }

        return duplicates.size();
    }
}
⏱ Complexity
Metric	Complexity
Time	O(n) → iterate through all characters once
Space	O(k) → k = number of distinct characters (≤ 36 letters + digits)
*/
