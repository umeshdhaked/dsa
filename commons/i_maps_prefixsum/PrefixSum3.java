package commons.i_maps_prefixsum;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum3 {
    
    //solve problem where nums[i] == nums[j] and equals to sum(i,j) in an given array.

    public static void main(String[] args) {
        int[] nums = new int[]{8,9,6,4,3,1,4,2,8,1,7,8,7};
        int n = nums.length;
        int[] prefixSum = new int[n];

        Map<Integer, Integer> sumToIdxMp = new HashMap<>();
        int sum =0;
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            prefixSum[i] = sum;
            sumToIdxMp.put(sum, i);
        }

        int ans = 0;
        for (int i=2;i<n;i++) {
            if(sumToIdxMp.containsKey(prefixSum[i-1] - nums[i])) {
                int idx = sumToIdxMp.get(prefixSum[i-1] - nums[i]);
                if (nums[idx] == nums[i]  && nums[i] == prefixSum[i-1] - prefixSum[idx]) {
                    System.out.println(idx + "--" + i);
                    ans++;
                }
            }
        }

        System.out.println(ans);
        
    }
}
