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
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
