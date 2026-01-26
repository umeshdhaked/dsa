import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {

        Map<Integer, List<Integer>> mpList = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            mpList.computeIfAbsent(nums[i], (val) -> new ArrayList<Integer>());
            mpList.get(nums[i]).add(i);
        }

        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int i=0; i<n; i++) {
            countsMap.put(nums[i], countsMap.get(nums[i]) + 1);
        }


        Map<Integer, Integer> calculatedSumMp  = new HashMap<>();
        long[] ans = new long[n];
        for (int i=0; i<n; i++) {
            if (calculatedSumMp.get(ans))
            List<Integer> indixes = mpList.get(nums[i]);
            long val = 0;
            for (int k : indixes) {
                val = val + Math.abs(i-k);
            }
            ans[i] = val;
        }

        return ans;
    }
}
// 1, 3, 5, 9
// 1, 4, 9, 18
// 14, 10, 10, 14