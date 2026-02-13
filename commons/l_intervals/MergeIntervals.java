package commons.l_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, this::compare);
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        ans.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];

            int[] topInterval = ans.getLast();

            if (topInterval[1] >= interval[0]) {
                topInterval[0] = Math.min(interval[0], topInterval[0]);
                topInterval[1] = Math.max(interval[1], topInterval[1]);
            } else {
                ans.add(interval);
            }

        }
        return ans.toArray(new int[0][]);
    }

    public int compare(int[] a, int[] b) {
        return a[0]-b[0];
    }

}