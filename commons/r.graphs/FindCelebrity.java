package questions;

import java.util.ArrayList;
import java.util.List;

public class FindCelebrity {

    public int celebrity(int mat[][]) {
        
        int n = mat.length;
        
        List<Integer> knowsNobuddy = new ArrayList<Integer>();
        
        for (int i =0;i<n;i++){
            boolean flag = true;
            for (int j = 0;j<n;j++) {
                if(mat[i][j] != 0 && i != j){
                    flag = false;
                }
            }
            if (flag) {
                knowsNobuddy.add(i);
            }
        }
        
        int m = knowsNobuddy.size();
        for (int i=0;i<m;i++) {
            int col = knowsNobuddy.get(i);
            boolean flag1 = true;
            for (int j=0;j<n;j++) {
                if (mat[j][col] != 1) {
                    flag1 = false;
                }
            } 
            if (flag1) {
                return col;
            }
        }
        return -1;

    }

}
