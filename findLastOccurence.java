public class Main {

    // Find the last occurrence of target in a sorted array
    public static int findLastOccurrence(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastIndex = mid;       // potential last occurrence
                left = mid + 1;        // search right half
            } else if (nums[mid] < target) {
                left = mid + 1;        // target is in right half
            } else {
                right = mid - 1;       // target is in left half
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 4, 5, 7};
        int target = 4;

        int last = findLastOccurrence(nums, target);
        System.out.println("Last occurrence of " + target + " is at index: " + last);
    }
}
