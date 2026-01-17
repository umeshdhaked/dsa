
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Demo Implementation of Trie data structure of 
 * 
*/

public class Dictionary {



    public void execute(){
        Trie root = new Trie(false);


        insert(root, "umesh");
        insert(root, "umeshdhaked");
        insert(root, "umeshkumardhaked");
        insert(root, "umeshsinghdhaked");
        insert(root, "praveen");

        System.out.println(anyStartWith(root, "umesh"));
        System.out.println(anyStartWith(root, "praveendhaked"));

        System.out.println(doesExists(root, "umeshsinghdhaked"));
        System.out.println(doesExists(root, "umeshdh"));

        System.out.println(listWordsStartWith(root, "umesh", 6));

        System.out.println("done");

    }

    public void insert(Trie root, String word){
        if (null == word || word.length() == 0) {
            return;
        }

        int j=0;
        Trie temp = root;
        for (char ch: word.toCharArray()) {
            j++;
            int i = ch - 'a';
            if(temp.nodes[i] == null) {
                temp.nodes[i] = new Trie(false);
                temp = temp.nodes[i];
            } else{
                temp = temp.nodes[i];
            }
            if (j==word.length()) {
                temp.isEnd = true;
            }
        }
    }


    public boolean doesExists(Trie root, String word) {
        Trie temp = root;

        for (char ch: word.toCharArray()) {
            if (temp.nodes[ch-'a'] != null) {
                temp = temp.nodes[ch-'a'];
            } else {
                return false;
            }
        }
        return temp.isEnd;
    }

    public boolean anyStartWith(Trie root, String prefix) {
        Trie temp = root;

        int i = 0;
        for (char ch: prefix.toCharArray()) {
            i++;
            if (temp.nodes[ch-'a'] != null) {
                temp = temp.nodes[ch-'a'];
            } else {
                return false;
            }
        }
        return i == prefix.length();
    }



    public List<String> listWordsStartWith(Trie root, String prefix, int depth) {
        Trie temp = root;

    
        for (char ch: prefix.toCharArray()) {
            if (temp.nodes[ch-'a'] != null) {
                temp = temp.nodes[ch-'a'];
            } else {
                return new ArrayList<>();
            }
        }
        List<String> words = new ArrayList<String>();
        getAllWordsWithPrefixAdded(temp, prefix, words, depth);
        return words;
    }

    // Better algoritm there using Queue for nodes.
    private void getAllWordsWithPrefixAdded(Trie node, String prefix, List<String> arrayList, int depth) {
        if(node.isEnd == true) {
            arrayList.add(prefix);
        }

        if (depth<=0) {
            return;
        }
        depth--;
        
        for (int i=0;i< node.nodes.length; i++) {
            if (node.nodes[i] != null) {
                String word = prefix + (char)(i+'a');
                getAllWordsWithPrefixAdded(node.nodes[i], word, arrayList, depth);
            }
        }
    }


    class Trie{
        boolean isEnd;
        Trie[] nodes;

        public Trie(boolean isEnd){
            this.isEnd = isEnd;
            this.nodes = new Trie[26];
        }
    }
    
}
