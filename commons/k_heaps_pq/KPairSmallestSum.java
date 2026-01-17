
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KPairSmallestSum {

    public static void main(String[] args) {

        int[] nums1 = { 1, 2, 4, 5, 6 };
        int[] nums2 = { 3, 5, 7, 9 };

        System.out.println(new KPairSmallestSum().kSmallestPairs(nums1, nums2, 20));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();

        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        priorityQueue.add(new int[] { 0, 0 });

        HashSet<String> set = new HashSet<>();

        set.add("0-0");

        while (true) {

            int[] an = priorityQueue.poll();

            int i = an[0];
            int j = an[1];
            ans.add(List.of(nums1[i], nums2[j]));

            if (ans.size() >= k) {
                break;
            }

            if (i < n - 1) {
                if (set.add((i + 1) + "-" + j)) {
                    priorityQueue.add(new int[] { i + 1, j });
                }
            }
             if (j < m - 1) {
                if (set.add(i + "-" + (j + 1))) {
                    priorityQueue.add(new int[] { i, j + 1 });
                }
            }
        }

        while (!priorityQueue.isEmpty() && ans.size() < k) {
            int[] an = priorityQueue.poll();
            ans.add(List.of(nums1[an[1]], nums2[an[2]]));
        }

        return ans;
    }


    // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    //     int n = nums1.length;
    //     int m = nums2.length;

    //     List<List<Integer>> ans = new ArrayList<>();

    //     Queue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> (a[0] - b[0]));

    //     for (int i =0;i< Math.min(n, k);i++) {
    //         priorityQueue.add(new int[]{nums1[i]+nums2[0],i,0});
    //     }

    //     while (!priorityQueue.isEmpty() && k > 0) {
            
    //         int[] val = priorityQueue.poll();
    //         int p = val[1];
    //         int q = val[2];

    //         if(q+1 < m) {
    //             priorityQueue.add(new int[]{nums1[p]+ nums2[q+1], p, q+1});
    //         }

    //         ans.add(List.of(nums1[p],nums2[q]));

    //         k--;
    //     }

    //     return ans;

    // }


}
