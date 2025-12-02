package commons;

import java.util.ArrayList;
import java.util.List;

public class TwoPointer {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int[] diff = new int[n];

        if (k==n) {
            List<Integer> res = new ArrayList<>();
            for (int val : arr) {
                res.add(val);
            }
            return res;
        }

        for (int i=0;i<n;i++) {
            diff[i] = Math.abs(arr[i]-k);
        }

        int i = 0;
        int j = arr.length-1;

        while (i-j >= k) {
            if (diff[i] > diff[j]) {
                i++;
            } else{
                j--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int l = i; l<j;l++) {
            ans.add(arr[l]);
        }

        return ans;
    }
    
}
