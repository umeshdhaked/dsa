package questions;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);

        
        return maxSum(nums, 0, dp);
    }

    public int maxSum(int[] nums, int i, int[] dp ) {

        if (nums.length <= i) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int notTake = maxSum(nums, i+1,dp);

        int take =  nums[i] + maxSum(nums, i+2,dp);

        dp[i] = Math.max(take, notTake);

        return dp[i];

    }

}
