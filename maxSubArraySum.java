public class Main {

    // Kadane's Algorithm to find maximum subarray sum
    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];      // global max
        int currentSum = nums[0];  // max sum ending at current position

        for (int i = 1; i < nums.length; i++) {
            // Either extend previous subarray or start new from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}
