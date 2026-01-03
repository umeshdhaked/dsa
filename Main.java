import pojo.TreeNode;
import questions.PrefixSearchEngine;


public class Main {

    public static void main(String[] args) { 
        System.out.println("MAIN");

        long time = System.currentTimeMillis();
        PrefixSearchEngine solution = new PrefixSearchEngine();
        solution.insert("umesh");
        solution.insert("umeshdhaked");
        solution.insert("umeshkumar");
        solution.insert("umeshkumardhaked");

        time = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()-time);
        System.out.println(solution.getTopWords("umesh"));
        System.out.println(System.currentTimeMillis()-time);

    }
}
