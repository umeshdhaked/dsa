package questions;

import java.util.HashMap;
import java.util.Map;

public class TrandingStocks {

    public static void main(String[] args) {

        String trend = "UFFFUD";  // trend of U, F, D
        int minAcceptableSubSequence = 2;
        int maxFinSubSequenceAllowed = 1;

        System.out.println(longestBalancedPeriod(trend, maxFinSubSequenceAllowed, minAcceptableSubSequence)); // not correct.
        System.out.println(solveUsingPrefixSum(trend, maxFinSubSequenceAllowed, minAcceptableSubSequence));


    }



    // This Sliding window does not work
    // SW only solves max frequencey
    // Sum <= K
    // at most K Distinct cherector.
    public static int longestBalancedPeriod(String trend, int k, int m) {
        int n = trend.length();
        int left = 0, maxLen = 0;
        int countU = 0, countD = 0, countF = 0;

        for (int right = 0; right < n; right++) {
            char c = trend.charAt(right);
            if (c == 'U') countU++;
            else if (c == 'D') countD++;
            else countF++;

            // Shrink window if flat days exceed k
            while (countF > k && left <= right) {
                char leftChar = trend.charAt(left++);
                if (leftChar == 'U') countU--;
                else if (leftChar == 'D') countD--;
                else countF--;
            }

            // Check if valid window
            int len = right - left + 1;
            if (countU == countD && countF <= k && len >= m) {
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }



    public static int solveUsingPrefixSum(String trend, int k, int m) {
        int countF = 0;
        
        for (int i = 0; i < trend.length(); i++) {
            if (trend.charAt(i) == 'F') {
                countF++;
            }
        }

        Map<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1); // diff 0 before start
        int countU = 0, countD = 0, maxLen = 0;

        for (int i = 0; i < trend.length(); i++) {
            char c = trend.charAt(i);
            if (c == 'U') countU++;
            else if (c == 'D') countD++;
            else countF--;

            int diff = countU - countD;

            if (!firstSeen.containsKey(diff)) {
                firstSeen.put(diff, i);
            } else {
                int start = firstSeen.get(diff);
                int len = i - start;
                if (countF <= k && len >= m) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

}
