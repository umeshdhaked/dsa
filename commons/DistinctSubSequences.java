package commons;

import java.util.Arrays;

public class DistinctSubSequences {
        int distinctSubseq(String s) {
        
        int n = s.length();
        int mod = 1_000_000_007;
    
        int[] dp = new int[n + 1];
        dp[0] = 1;
    
        int[] last = new int[256];
        Arrays.fill(last, -1);
    
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
    
            dp[i] = (2 * dp[i - 1]) % mod;
    
            if (last[c] != -1) {
                dp[i] = (dp[i] - dp[last[c] - 1] + mod) % mod;
            }
    
            last[c] = i;
        }
    
        return dp[n];
    
    }
}
