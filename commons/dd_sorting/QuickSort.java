package commons.dd_sorting;

import java.util.Random;

public class QuickSort {
    
    public void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private void quickSortHelper(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        quickSortHelper(a, lo, p - 1);
        quickSortHelper(a, p + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int rand = new Random().nextInt(hi-lo+1)+lo;
        swap(a, hi, rand);

        int pivotVal = a[hi];
        int pivotIdx = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivotVal) {
                swap(a, pivotIdx, j);
                pivotIdx++;
            }
        }
        swap(a, pivotIdx, hi);
        return pivotIdx;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
