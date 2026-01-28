import java.util.Arrays;

public class Main {

    // Minimum number of coins to make up the amount
    public static int coinChange(int[] coins, int amount) {

        final int INF = amount + 1; // Use amount+1 as infinity (can't be formed)
        int[] dp = new int[amount + 1];

        // Initialize DP array
        Arrays.fill(dp, INF);
        dp[0] = 0; // 0 coins needed to make 0

        // Fill DP table
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int minCoins = coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + minCoins);
    }
}
