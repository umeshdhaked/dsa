

class SlidingWindow {

       public int longestOnes(int[] nums, int k) { // not optimal
        int n = nums.length;

        int maxCount = 0;
        for (int i=0; i<n; i++){
            int count = 0;

            int iVal = nums[i];
            if (k > 0) {
                iVal = 1;
            }

            int tempK = k;
            for (int j=i; j<n; j++) {
                int jVal = nums[j];
                if (jVal == 0 && tempK > 0) {
                    tempK--;
                    jVal = 1;
                }

                if(iVal == 1 && jVal==1) {
                   count++;
                   continue;
                }
                break;
            }

            for (int p=i;p<n;p++) {
                if (nums[p] == 0) {
                    i = p;
                    break;
                }
            }

            maxCount = Math.max(count,maxCount);
        }


        return maxCount;
    }




       public int longestOnesOptimal(int[] nums, int k) {
        int n = nums.length;

        int maxCount = 0;

        int left = 0;
        int right = 0;

    
        int tempK = k;
        int count = 0;
        while (left < n && right < n && left <= right) {

            if (nums[right] == 1){
                count++;
                right++;
                continue;
            }

            if (nums[right] == 0 && tempK>0) {
                tempK--;
                count++;
                right++;
                continue;
            }

            maxCount = Math.max(maxCount, count);

            while (tempK <= 0) {
                if (nums[left] == 1) {
                    left++;
                    count--;
                } else{
                    left++;
                    tempK++;
                    count--;
                }
                
            }
        }
      

        return maxCount;
    }

    
}