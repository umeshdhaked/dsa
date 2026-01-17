public class QuickSelectAlgo {

    public int quickSelect(int[] arr, int k) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array is null/empty");
        if (k < 1 || k > arr.length) throw new IllegalArgumentException("k is out of range");
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1);
    }

    private int quickSelectHelper(int[] a, int lo, int hi, int kIndex) {
        while (lo <= hi) {
            int p = partition(a, lo, hi);
            if (p == kIndex) return a[p];
            else if (kIndex < p) hi = p - 1;
            else lo = p + 1;
        }
        return -1; // should not reach here if inputs valid
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
