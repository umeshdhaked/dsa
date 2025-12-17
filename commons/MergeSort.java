
import java.util.Arrays;

public class MergeSort {

    public void execute() {

        int[] numbers = new int[] { 21, 343, 5, 3, 67, 23, 657, 8, 5444, 46, 6536, 2, 6, 6 };

        // bubbleSort(numbers);

        mergeSort(numbers, 0, numbers.length - 1);

        for (int num : numbers) {
            System.out.println(num + ",");
        }

    }

    public void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
    }

    public void mergeSort(int[] numbers, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(numbers, start, mid);
        mergeSort(numbers, mid+1, end);
        merge(numbers, start, mid, end);
    }


    public void merge(int[] num, int start, int mid, int end) {
        
        int leftSize = mid-start+1;
        int[] left = new int[leftSize];

        int rightSize = end-mid;
        int[] right = new int[rightSize];

        for (int i=0;i<leftSize;i++){
            left[i] = num[start+i];
        }

        for (int i=0;i<rightSize;i++){
            right[i] = num[mid+i+1];
        }

        int i=0;
        int j=0;
        int k =0;
        while(i<leftSize && j<rightSize) {
            if(left[i]<right[j]) {
                num[k+start] = left[i];
                i++;
            } else{
                num[k+start] = right[j];
                j++;
            }
            k++;
        }

        while (i<leftSize) {
            num[k+start] = left[i];
            i++;
            k++;
        }

        while (j<rightSize) {
            num[k+start] = right[j];
            j++;
            k++;
        }

    }

}
