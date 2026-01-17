package questions;

public class MooreVotingAlgo {
    public int mostFreqEle(int[] arr) {

        int freqNum = arr[0];
        int counts = 1;

        for(int i=1; i<arr.length; i++) {
            // System.out.println(maxNum+"loop start"+ counts);
            if (counts < 0) {
                freqNum = arr[i];
                counts++;
            }
            // System.out.println(maxNum+"loop mid"+ counts);

            if (freqNum == arr[i]){
                counts++;
            } else {
                counts--;
            }

            // System.out.println(maxNum+"loop end"+ counts);
        }
        
           if (counts < 0) {
                freqNum = arr[arr.length-1];
            }
        
        // System.out.println("fin count"+ counts);

        return freqNum;
    }
}