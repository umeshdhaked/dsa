

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);


        combinationSum2Helper(candidates, target, 0,  ans, new ArrayList<>());

        return ans;
        
    }


    private void combinationSum2Helper(int[] candidates, int target, int start,  List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for ( int i = start; i < candidates.length; i++) {
            if (start < i && candidates[i-1] == candidates[i]) {
                continue;
            }

            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                combinationSum2Helper(candidates, target-candidates[i], i+1, ans, temp);
                temp.remove(temp.size()-1);
            } else{
                break;
            }
        }
    }

}
