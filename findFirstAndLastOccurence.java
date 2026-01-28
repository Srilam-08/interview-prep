public class Main {

    // Finds the first and last position of target in sorted array
    public static int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }

        // Find first index where nums[i] >= target
        int first = findFirst(nums, target, true);

        // If target not found
        if (first == -1 || nums[first] != target) {
            return new int[]{-1, -1};
        }

        // Find first index where nums[i] > target
        int afterLast = findFirst(nums, target, false);

        int last = (afterLast == -1) ? n - 1 : afterLast - 1;

        return new int[]{first, last};
    }

    // Binary search to find first index matching condition
    private static int findFirst(int[] nums, int target, boolean greaterOrEqual) {

        int left = 0, right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean condition = greaterOrEqual
                    ? nums[mid] >= target
                    : nums[mid] > target;

            if (condition) {
                answer = mid;
                right = mid - 1; // search left part
            } else {
                left = mid + 1;  // search right part
            }
        }

        return answer;
    }

    // Main method to test the code
    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.println("First Index: " + result[0]);
        System.out.println("Last Index: " + result[1]);
    }
}
