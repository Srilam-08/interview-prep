public class Main {

    // Function to find the equilibrium index
    public static int findEvenIndex(int[] arr) {

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num; // compute total sum
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i]; // remaining sum on the right
            if (leftSum == rightSum) {
                return i; // found the lowest index where left == right
            }
            leftSum += arr[i]; // update left sum
        }

        return -1; // no index found
    }

    public static void main(String[] args) {

        int[][] testArrays = {
            {1, 2, 3, 4, 3, 2, 1},
            {1, 100, 50, -51, 1, 1},
            {20, 10, -80, 10, 10, 15, 35},
            {1, 2, 3},
            {0, 0, 0, 0}
        };

        for (int[] arr : testArrays) {
            System.out.println("Array: " + java.util.Arrays.toString(arr));
            System.out.println("Equilibrium Index: " + findEvenIndex(arr));
            System.out.println();
        }
    }
}
