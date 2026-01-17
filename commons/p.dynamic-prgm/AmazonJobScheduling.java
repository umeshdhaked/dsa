package questions;

import java.util.*;

public class AmazonJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<Map<Integer, Integer>> jobs = new ArrayList<>();

        for (int i = 0; i < profit.length; i++) {
            jobs.add(Map.of(0,startTime[i], 1, endTime[i], 2, profit[i]));
        }
        jobs.sort(this::compare);

        int dp[] = new int[profit.length];
        dp[0] = jobs.get(0).get(2);

        for (int i = 1; i < profit.length; i++) {
            int checkLastCanBeTakenIndex = search(jobs, i);

            if (checkLastCanBeTakenIndex == -1) {
                dp[i] = Math.max(dp[i - 1], jobs.get(i).get(2));
            } else {
                dp[i] = Math.max(dp[i - 1], dp[checkLastCanBeTakenIndex] + jobs.get(i).get(2));
            }
        }

        return dp[profit.length - 1];

    }

    private int search(List<Map<Integer, Integer>> jobs, int i) {
        int startTime = jobs.get(i).get(0);
        int start = 0;
        int end = i - 1; // only look at jobs before i 
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2; // compare against END TIME (index 1), not profit 
            if (jobs.get(mid).get(1) <= startTime) {
                result = mid; // candidate found 
                start = mid + 1; // try to find later compatible job 
            } else {
                end = mid - 1;
            }
        }
        return result; // -1 if none found 
    }

    int compare(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        return a.get(1) - b.get(1);
    }

}