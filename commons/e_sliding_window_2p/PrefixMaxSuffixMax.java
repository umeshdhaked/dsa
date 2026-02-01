package commons.e_sliding_window_2p;

public class PrefixMaxSuffixMax {

    public int trap(int[] height) {

        int left_max = 0;
        int right_max = 0;

        int left = 0;
        int right = height.length - 1;

        int ans = 0;
        while (left < right) {

            if (height[left] < height[right]) {
                if (left_max <= height[left]) {
                    left_max = height[left];
                } else {
                    ans = ans + (left_max - height[left]);
                }

            } else {
                if (right_max < height[right]) {
                    right_max = height[right];
                } else {
                    ans = ans + (right_max - height[right]);
                }
                right--;
            }

        }
        return ans;
    }

}