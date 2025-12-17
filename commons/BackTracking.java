
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BackTracking {



    private List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(nums, 0, ans, new ArrayList<>());


        return ans;
    }


    private static void backtrack(int[] nums, int start, List<List<Integer>> ans, ArrayList<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i+1, ans, temp);
            temp.remove(temp.size()-1);
        }
    }



    /*
        Below Solution also have same time and space complexity, it's just not that readable and uses BFS.
     */
    public List<List<Integer>> subsetsV2(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            queue.add(Arrays.asList(nums[i], i+1));
        }

        while (!queue.isEmpty()) {
            List<Integer> set = queue.poll();
            List<Integer> subList = set.subList(0, set.size()-1);
            ans.add(subList);
            
            int nextStartIndex = set.get(set.size()-1);

            while (nextStartIndex < nums.length) {
                List<Integer> newSet = new ArrayList<>(subList);
                newSet.add(nums[nextStartIndex]);
                queue.add(newSet);
                nextStartIndex++;
                newSet.add(nextStartIndex);
            } 
        }

        return ans;
    }
    
}
