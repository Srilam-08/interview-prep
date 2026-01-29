import java.util.*;

public class Main {

    // Method to group anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {

        // Map: sorted string -> list of anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Convert string to char array and sort
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            // Convert back to string as key
            String key = new String(charArray);

            // Add original string to its anagram group
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Return all groups as a list
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> grouped = groupAnagrams(strs);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : grouped) {
            System.out.println(group);
        }
    }
}
/*
import java.util.*;

class Main {
    static List<List<String>> groupAnagrams(String[] a) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : a) {
            int[] f = new int[26];
            for (char c : s.toCharArray()) f[c - 'a']++;
            m.computeIfAbsent(Arrays.toString(f), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(m.values());
    }
}
O(n * k)
    (n = number of strings, k = average string length)
    */
