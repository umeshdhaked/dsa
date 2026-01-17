package commons.k_heaps_pq;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopFrequentKElement {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        for(int num:nums) {
            int count = mp.getOrDefault(num, 0);
            mp.put(num,count+1);
        } 

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {return b.freq - a.freq;});

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] ans = new int[k];
        int i =0;
        while (i<k && !pq.isEmpty()) {
            ans[i] = pq.poll().val;
            i++;
        }
        return ans;
    }

    class Pair {
        int val;
        int freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
}
