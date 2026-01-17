package questions;

import java.util.Arrays;

public class PaintTheWall {


   public int paintWalls(int[] cost, int[] time) {
        
        int[][] dp = new int[cost.length+1][cost.length+1];
        for (int i=0;i<=cost.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return paintWallHalper(cost, time, 0,cost.length, dp);
    }

    public int paintWallHalper(int[] cost, int[] time, int i, int wallsToPaint, int[][] dp){
        if (wallsToPaint <= 0 ) {
            return 0;
        }

        if (i >= cost.length) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][wallsToPaint] != -1) {
            return dp[i][wallsToPaint];
        }

        int amountWhenTake = Integer.MAX_VALUE;
        amountWhenTake = paintWallHalper(cost, time, i+1, wallsToPaint - (time[i]+1), dp);
        if (amountWhenTake != Integer.MAX_VALUE) {
            amountWhenTake += cost[i];
        }

        int amountWhenNotTake = paintWallHalper(cost, time, i+1, wallsToPaint, dp);

        dp[i][wallsToPaint] = Math.min(amountWhenTake, amountWhenNotTake);

        return dp[i][wallsToPaint];
    }


    public int paintWallHalper2(int[] cost, int[] time) {
        int[][] dp = new int[cost.length][cost.length];
        // i -> walls to paint
        // j -> number of wall remaining;

        for (int j=0;j<cost.length;j++) {
            dp[0][j] = 0;
        }
        for (int i=0;i<cost.length;i++) {
            dp[i][cost.length-1] = Integer.MAX_VALUE;
        }

        for (int i =0;i<cost.length;i++) {
            for (int j =0;j< cost.length; j++) {
                
            }
        }

        return 0;
    }




}

