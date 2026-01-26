package commons.i_maps_prefixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumofDistances {
   public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> mpList = new HashMap<>();
        int n = nums.length;

        // Step 1: group indices
        for (int i = 0; i < n; i++) {
            mpList.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[n];

        // Step 2: process each group
        for (List<Integer> indices : mpList.values()) {
            int m = indices.size();
            long[] prefix = new long[m + 1];

            // Build prefix sums
            for (int j = 0; j < m; j++) {
                prefix[j + 1] = prefix[j] + indices.get(j);
            }

            // Compute distances using formula
            for (int j = 0; j < m; j++) {
                int idx = indices.get(j);
                long left = (long) j * idx - prefix[j];
                long right = (prefix[m] - prefix[j + 1]) - (long) (m - j - 1) * idx;
                ans[idx] = left + right;
            }
        }

        return ans;
    }
}
