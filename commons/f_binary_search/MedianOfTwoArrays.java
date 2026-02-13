package commons.f_binary_search;

public class MedianOfTwoArrays {




public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Ensure nums1 is the smaller array to minimize binary search space
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }

    int n = nums1.length;
    int m = nums2.length;
    int low = 0, high = n;

    while (low <= high) {
        // Partition nums1 at i, nums2 at j
        int i = (low + high) / 2;
        int j = (n + m + 1) / 2 - i;

        // Edge values (use -∞ and +∞ for out-of-bound cases)
        int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
        int right1 = (i == n) ? Integer.MAX_VALUE : nums1[i];
        int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int right2 = (j == m) ? Integer.MAX_VALUE : nums2[j];

        // Check if partition is correct
        if (left1 <= right2 && left2 <= right1) {
            // Found correct partition
            if ((n + m) % 2 == 0) {
                // Even total length → average of two middle values
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else {
                // Odd total length → max of left side
                return Math.max(left1, left2);
            }
        } else if (left1 > right2) {
            // Too far right in nums1 → move left
            high = i - 1;
        } else {
            // Too far left in nums1 → move right
            low = i + 1;
        }
    }

    throw new IllegalArgumentException("Input arrays are not sorted properly.");
}





    // Little Naive
    public double findMedianSortedArraysSpace(int[] nums1, int[] nums2) {

        int i = 0;
        int m = nums1.length;
        int j = 0;
        int n = nums2.length;
        int total = m + n;

        int count = 0;
        int mid1 = 0;
        int mid2 = 0;

        while (i < m && j < n) {
            count++;
            if (nums1[i] < nums2[j]) {
                int[] temp = mids(nums1, count, total, i, mid1, mid2);
                mid1 = temp[0];
                mid2 = temp[1];
                i++;
            } else {
                int[] temp = mids(nums2, count, total, j, mid1, mid2);
                mid1 = temp[0];
                mid2 = temp[1];
                j++;
            }

            if (count > 1 + (total / 2)) {
                break;
            }
        }

        while (i < m) {
            count++;
            int[] temp = mids(nums1, count, total, i, mid1, mid2);
            mid1 = temp[0];
            mid2 = temp[1];
            i++;
            if (count > 1 + (total / 2)) {
                break;
            }
        }

        while (j < n) {
            count++;
            int[] temp = mids(nums2, count, total, j, mid1, mid2);
            mid1 = temp[0];
            mid2 = temp[1];
            j++;
            if (count > 1 + (total / 2)) {
                break;
            }
        }

        return ((double) mid1 + (double) mid2) / 2;

    }

    public int[] mids(int[] nums, int count, int total, int idx, int mid1, int mid2) {
        int[] mids = new int[] { mid1, mid2 };
        if (count < total / 2) {
            return mids;
        }
        if (total % 2 == 0) {
            if (count == total / 2) {
                mids[0] = nums[idx];
            }
            if (count == 1 + (total / 2)) {
                mids[1] = nums[idx];
            }
        } else {
            if (count == 1 + (total / 2)) {
                mids[0] = nums[idx];
                mids[1] = nums[idx];
            }
        }
        return mids;
    }




    // GAP uses to fully sort both
    public double findMedianSortedArraysGAP(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int total = n + m;

    // Function to get next gap
    java.util.function.IntUnaryOperator nextGap = (gap) -> {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }; 

    // Start with initial gap
    int gap = nextGap.applyAsInt(total);

    while (gap > 0) {
        int i = 0;
        int j = gap;

        while (j < total) {
            // Get ith and jth element (virtual indexing)
            int valI = (i < n) ? nums1[i] : nums2[i - n];
            int valJ = (j < n) ? nums1[j] : nums2[j - n];

            if (valI > valJ) {
                // Swap across arrays if needed
                if (i < n && j < n) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                } else if (i < n && j >= n) {
                    int temp = nums1[i];
                    nums1[i] = nums2[j - n];
                    nums2[j - n] = temp;
                } else {
                    int temp = nums2[i - n];
                    nums2[i - n] = nums2[j - n];
                    nums2[j - n] = temp;
                }
            }
            i++;
            j++;
        }
        gap = nextGap.applyAsInt(gap);
    }

    // Now arrays are merged in sorted order
    if (total % 2 == 1) {
        // Odd length
        int mid = total / 2;
        return (mid < n) ? nums1[mid] : nums2[mid - n];
    } else {
        // Even length
        int mid1 = total / 2 - 1;
        int mid2 = total / 2;
        int val1 = (mid1 < n) ? nums1[mid1] : nums2[mid1 - n];
        int val2 = (mid2 < n) ? nums1[mid2] : nums2[mid2 - n];
        return (val1 + val2) / 2.0;
    }
}


}
