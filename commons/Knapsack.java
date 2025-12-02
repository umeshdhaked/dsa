package commons;

import java.util.Arrays;

public class Knapsack {

   public int rob(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }


        int[] dp = new int[nums.length];

        // staring from 0 and not taking the last
        Arrays.fill(dp, -1);
        int ans1 = findMaxMoney(nums, 0, nums.length-1, dp);

        // starting from 1 can take the last.
        Arrays.fill(dp, -1);
        int ans2 = findMaxMoney(nums, 1, nums.length, dp);

        return Math.max(ans1, ans2);
    }

    private int findMaxMoney(int[] nums, int i, int length, int[] dp) {
        if(i >= length ) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int take =  nums[i] + findMaxMoney(nums, i+2, length, dp);

        int notTake = findMaxMoney(nums, i+1, length, dp);

        dp[i] = Math.max(take, notTake);

        return dp[i];
    }

}
