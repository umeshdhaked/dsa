package commons.f_binary_search;

import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int n = stalls.length;

        int maxGap = stalls[n-1];
        int minGap = Integer.MAX_VALUE;

        int prev = Integer.MIN_VALUE + stalls[0] + 1;
        for(int val:stalls) {
            minGap = Math.min(minGap, (val-prev));
            prev = val;
        }
        
        int ans = Integer.MIN_VALUE;
        while (minGap <= maxGap) {
            int gap = (maxGap+minGap)/2;

            boolean canCowsFit = canCowsFit(stalls, k, gap);
            
            if(canCowsFit) {
                ans = Math.max(ans, gap);
                minGap = gap+1;
            } else {
                maxGap = gap-1;
                
            }
        }

        return ans;
    }

    private boolean canCowsFit(int[] stalls, int k, int gap) {

        k--;
        int prev = stalls[0];
        for(int i=1; i< stalls.length; i++) {
            int currGap = stalls[i] - prev;
            if (currGap >= gap) {
                k--;
                prev = stalls[i];
            }
        }

        return k <= 0;
        
    }
}