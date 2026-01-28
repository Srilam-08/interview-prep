import java.util.*;

// Class to represent either a single integer OR a nested list
class NestedInteger {
    Integer value;                  // Stores single integer
    List<NestedInteger> list;        // Stores nested list

    // Constructor for an empty list
    public NestedInteger() {
        list = new ArrayList<>();
    }

    // Constructor for a single integer
    public NestedInteger(int value) {
        this.value = value;
    }

    // Returns true if this holds a single integer
    public boolean isInteger() {
        return value != null;
    }

    // Add a NestedInteger to the list
    public void add(NestedInteger ni) {
        list.add(ni);
    }

    // Get the integer value (if present)
    public Integer getInteger() {
        return value;
    }

    // Get the nested list
    public List<NestedInteger> getList() {
        return list;
    }
}

class Solution {

    // Convert a string like "123" or "[123,[456,789]]" into NestedInteger
    public NestedInteger deserialize(String s) {

        // If the string does not start with '[', it is just a number
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        // Create an empty NestedInteger list for result
        NestedInteger result = new NestedInteger();

        int depth = 0;   // Tracks nested bracket depth
        int start = 1;   // Start index after '['

        // Loop through the string character by character
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            // Increase depth when encountering '['
            if (c == '[') {
                depth++;
            }
            // Decrease depth when encountering ']'
            else if (c == ']') {
                depth--;
            }

            // If at top-level and find a comma OR reach end of string
            if ((c == ',' && depth == 0) || i == s.length() - 1) {

                // Extract current element substring
                String part = s.substring(start, i);

                // Avoid empty strings
                if (!part.isEmpty()) {
                    // Recursively deserialize and add to list
                    result.add(deserialize(part));
                }

                // Move start to next element
                start = i + 1;
            }
        }

        return result;
    }
}
