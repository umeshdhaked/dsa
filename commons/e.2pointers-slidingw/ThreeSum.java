package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Sum of any three values should be zero. (hint sort the array.)
 */

public class ThreeSum {

    public void execute() {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            // int j = i + 1;
            // int k = nums.length - 1;

            // while (j < k) {
            //     int b = nums[j];
            //     int c = nums[k];
            //     if (a + b + c > 0) {
            //         k--;
            //     } else if (a + b + c < 0) {
            //         j++;
            //     } else {
            //         ans.add(Arrays.asList(a, b, c));
            //         while (j < k && nums[j] == b) {
            //             j++;
            //         }
            //         while (j < k && nums[k] == c) {
            //             k--;
            //         }
            //     }
            // }


            int target = 0 - a;
            Map<Integer, Integer> mp = new HashMap<>();
            for (int l=i+1;l< nums.length;l++) {
                int curr = nums[l];
                if (mp.containsKey(target-curr)) {
                    ans.add(Arrays.asList(nums[i],target-curr,curr));
                    while ( l+1 < nums.length && curr == nums[l+1]) {
                        l++;
                    }
                } else{
                    mp.put(nums[l], l);
                }
            }

            while ( i+1 < nums.length && a == nums[i+1]) {
                i++;
            }
        }
        System.out.println(new ArrayList<>(ans));
    }
}
