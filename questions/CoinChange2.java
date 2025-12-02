package questions;

import java.util.Arrays;

public class CoinChange2 {
    
  
    public int coinChange(int[] coins, int amount) {

        // int ans = minimumCoin(coins, amount, 0, 0);
        // if (ans == Integer.MAX_VALUE) {
        //     return -1;
        // } else{
        //     return ans;
        // }


        // long[][] memo = new long[coins.length+1][amount+1];

        // for(long[] rows: memo)
        //     Arrays.fill(rows, -1);

        // long ans = minimumCoinMemo(coins, amount, 0, memo);
        // if (ans == Integer.MAX_VALUE) {
        //     return -1;
        // } else{
        //     return (int)ans;
        // }

        // int[][] memo = new int[coins.length+1][amount+1];

        // for (int i = coins.length-1 ; i >= 0;i--) {
        //     for( int sum = 1; sum <= amount; sum ++) {
        //         memo[i][sum] = Integer.MAX_VALUE;
        //         int take = Integer.MAX_VALUE;
        //         int notTake = Integer.MAX_VALUE;

        //         // take it
        //         if (sum - coins[i] >= 0) {
        //             take = memo[i][sum-coins[i]];
        //             if (Integer.MAX_VALUE != take) take++;
        //         }

        //         // not take
        //         if (i+1 < coins.length) {
        //             notTake = memo[i+1][sum];
        //         }

        //         memo[i][sum] = Math.min(take, notTake);

        //     } 
        // }




        int[] memo = new int[amount+1]; 
        Arrays.fill(memo, Integer.MAX_VALUE);

        memo[0] = 0;
        for (int i = coins.length-1 ; i >= 0;i--) {
            for( int sum = 1; sum <= amount; sum ++) {
                int take = Integer.MAX_VALUE;
                int notTake = Integer.MAX_VALUE;

                // take it
                if (sum - coins[i] >= 0) {
                    take = memo[sum-coins[i]];
                    if (Integer.MAX_VALUE != take) take++;
                }

                // not take
                if (i+1 < coins.length) {
                    notTake = memo[sum];
                }

                memo[sum] = Math.min(take, notTake);

            } 
        }

        int ans = memo[amount];
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else{
            return (int)ans;
        }

    }
    

    
    private long minimumCoinMemo(int[] coins, int amount, int i, long[][] memo) {
       if (amount == 0) {
            return 0;
        }
        if (amount < 0 || i >= coins.length){
            return Integer.MAX_VALUE;
        }

        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }


        long minCoinNumTaken = minimumCoinMemo(coins, amount-coins[i], i, memo);
        minCoinNumTaken++;
        
        long minCoinNumNotTaken = minimumCoinMemo(coins, amount, i+1, memo);

    
        memo[i][amount] = Math.min(minCoinNumTaken,minCoinNumNotTaken);

        return memo[i][amount];

    }



    public int minimumCoin(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            return count;
        }
        if (amount < 0 || index >= coins.length){
            return Integer.MAX_VALUE;
        }


        int minCoinNumTaken = minimumCoin(coins, amount-coins[index], index, count+1);

        int minCoinNumNotTaken = minimumCoin(coins, amount, index+1, count);

        return Math.min(minCoinNumTaken,minCoinNumNotTaken);

    }



    public void execute() {
        // int[] coins = new int[]{1,2,5};
        int[] coins = new int[]{411,412,413,414,415,416,417,418,419,420,421,422};


        // int amount = 11;
        int amount = 9864;

        System.out.println(coinChange(coins, amount));

    }
    
}
