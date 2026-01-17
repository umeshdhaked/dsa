package questions;

// Math + Binarysearch
public class SplitLargestArraySum {

    public int splitArray(int[] nums, int k) {

        if (nums.length < k) {
            return -1;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            max = Math.max(max, num);
            sum = sum + num;
        }

        while (max <= sum) {
            int allowedToSum = (max + sum)/2;

            int countsToSum = minArrayCounter(nums, allowedToSum);

            if (countsToSum > k) {
                max = allowedToSum+1;
            } else {
                sum = allowedToSum;
            }
            
        }
        return max;
    }

    private int minArrayCounter(int[] nums, int allowedToSum) {

        int counts = 1;
        int currSum =0;
        for (int i=0;i<nums.length;i++){
            if(currSum + nums[i] <= allowedToSum) {
                currSum = currSum + nums[i];
            } else{
                currSum = nums[i];
                counts++;
            }
        }
        return counts;
    }           


    
}
