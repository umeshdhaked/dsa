package questions;

class KthMissingNumber {
    public int findKthPositive(int[] arr, int k) { // for sorted array

        int n = arr.length;
        int skipped = 0;
        for (int i=0; i < n ;i++) {
            int vali = arr[i];

            skipped = vali-(i+1);

            if (skipped >= k) {
                return vali - (k-skipped) - 1;
            }

        }

        if (skipped < k ) {
            return arr[n-1] + (k-skipped);
        }

        return 0;
    }

    public int firstMissingPositive(int[] nums) { // for unsorted array
        int n = nums.length;

        for (int i =0;i<n;i++) {
            int val = nums[i];
            while(val > 0 && val <= nums.length && nums[val-1] != Integer.MIN_VALUE) {
                int temp = nums[val-1];
                nums[val-1] = Integer.MIN_VALUE;
                val = temp;
            }
        }

        for (int i = 0;i<n;i++) {
            if (nums[i] != Integer.MIN_VALUE) {
                return i+1;
            }
        }

        return nums.length+1;
    }

    // Find the duplicate in unique array of 1 to n elemnts in n+1 array. (same pattern)

}