

import java.util.HashMap;

public class PrefixSum2 {


    //  find substring for equal U, D trend, given string comtains U, F, D.
    //  where number of U should be equal number of D and F occurence has max limit in substring ,
    //  and subsequence should be of maxumum length with above condition ?
    public static void main(String[] args) {
            String S = "UFUDUFFUDF";
            int k = 2;

            new PrefixSum2().solve(S, k);
            new PrefixSum2().solve1(S, k);
    }

    public void solve(String S, Integer k) {
            int n = S.length();

            int[] countF = new int[n];
            if (S.charAt(0) == 'F') {
                countF[0]++;
            }
            for (int i=1;i<n;i++) {
                if (S.charAt(i) == 'F') {
                    countF[i] = countF[i-1]+1;
                } else{
                     countF[i] =  countF[i-1];
                }  
            }

            int ans = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            int countD = 0;
            int countU = 0;
            for(int i =0;i<n;i++) {
                if (S.charAt(i) == 'U') {
                    countU++;
                }
                if (S.charAt(i) == 'D') {
                    countD++;
                }

                int diff = countU - countD;

                if (!mp.containsKey(diff)) {
                    mp.put(diff, i);
                } else {
                    int startId = mp.get(diff);
                    if (countF[i] - countF[startId] <= k) {
                         ans = Math.max(ans, i-startId);
                    }
                }
            }
            System.out.println(ans);
    }


    public void solve1(String S, Integer k) {
            int n = S.length();
            int ans =0;
            for (int i =0;i<n;i++) {
                int countD = 0;
                int countU = 0;
                int countF = 0;
                for (int j=i;j<n;j++) {
                    if (S.charAt(j) == 'U') countU++;
                    if (S.charAt(j) == 'D') countD++;
                    if (S.charAt(j) == 'F') countF++;
                    if (countU == countD && countF <= k) {
                        ans = Math.max(ans, j-i+1);
                    }
                }
            }
            System.out.println(ans); 
    }

    
}
