package questions;

import java.util.*;

/**
 * Prefix search engine that keeps the top‑50 most frequent words reachable
 * from any node at depth ≥ 4. Words are stored once in a global pool and
 * referenced by indices to avoid duplication.
 */
public class PrefixSearchEngine {

    /**
     * Simple global word pool – each word is stored only once.
     */
    private static class WordPool {
        private final List<String> words = new ArrayList<>();
        private final Map<String, Integer> indexMap = new HashMap<>();

        int getIndex(String w) {
            return indexMap.computeIfAbsent(w, k -> { words.add(k); return words.size() - 1; });
        }

        String getWord(int idx) {
            return words.get(idx);
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        // indices of top words for this node (depth ≥ 4)
        Set<Integer> topSet = new HashSet<>();
    }

    private final WordPool pool = new WordPool();
    private final int[] freq; // parallel to words list, dynamic size
    private final TrieNode root = new TrieNode();

    public PrefixSearchEngine() {
        // initial capacity; will grow dynamically
        freq = new int[1024];
    }

    /**
     * Ensures freq array has enough capacity.
     */
    private void ensureFreqCapacity(int idx) {
        if (idx >= freq.length) {
            int newSize = Math.max(idx + 1, freq.length * 2);
            freqArraysCopy(freq, newSize);
        }
    }

    private void freqArraysCopy(int[] src, int newSize) {
        int[] dst = Arrays.copyOf(src, newSize);
        // replace reference
    }

    /**
     * Insert a word; increments its frequency and updates top‑50 lists.
     */
    public void insert(String word) {
        if (word == null || word.isEmpty()) return;
        int idx = pool.getIndex(word);
        ensureFreqCapacity(idx);
        freq[idx]++;

        TrieNode node = root;
        int depth = 0;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            depth++;
            if (depth >= 4) {
                updateTopSet(node, idx);
            }
        }
    }

    private void updateTopSet(TrieNode node, int idx) {
        if (!node.topSet.contains(idx)) {
            node.topSet.add(idx);
        }
        if (node.topSet.size() > 50) {
            // remove the least frequent
            int minIdx = -1;
            int minFreq = Integer.MAX_VALUE;
            for (int id : node.topSet) {
                if (freq[id] < minFreq) {
                    minFreq = freq[id];
                    minIdx = id;
                }
            }
            if (minIdx != -1) {
                node.topSet.remove(minIdx);
            }
        }
    }

    /**
     * Return top words for a given prefix.
     */
    public List<String> getTopWords(String prefix) {
        if (prefix == null || prefix.isEmpty()) return Collections.emptyList();
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return Collections.emptyList();
        }
        // Collect words from the node's topSet and sort by frequency desc
        List<Integer> indices = new ArrayList<>(node.topSet);
        indices.sort((a, b) -> Integer.compare(freq[b], freq[a]));
        List<String> result = new ArrayList<>();
        for (int id : indices) {
            result.add(pool.getWord(id));
        }
        return result;
    }
}
// package questions;
// import java.util.ArrayList;
// import java.util.List;

// public class PrefixSearchEngine {
// 	/**
// 	 * Simple Trie implementation for storing words and retrieving all words
// 	 * that share a common prefix.
// 	 */
// 	private static class TrieNode {
// 		java.util.Map<Character, TrieNode> children = new java.util.HashMap<>();
// 		boolean isWord;
// 		// For nodes at depth 3 or more we keep a list of words that can be reached from this node.
// 		java.util.List<String> wordsFromHere;
// 	}

// 	private final TrieNode root = new TrieNode();

// 	/**
// 	 * Inserts a word into the trie.
// 	 */
// 	public void insert(String word) {
// 		if (word == null || word.isEmpty()) return;
// 		TrieNode node = root;
// 		int depth = 0;
// 		for (char ch : word.toCharArray()) {
// 			node = node.children.computeIfAbsent(ch, k -> new TrieNode());
// 			depth++;
// 			if (depth >= 3) {
// 				if (node.wordsFromHere == null) node.wordsFromHere = new java.util.ArrayList<>();
// 				// Avoid duplicate entries
// 				if (!node.wordsFromHere.contains(word)) node.wordsFromHere.add(word);
// 			}
// 		}
// 		node.isWord = true;
// 	}

// 	/**
// 	 * Returns a list of all words that start with the given prefix.
// 	 * If the prefix is shorter than 3 characters, an empty list is
// 	 * returned to optimize space usage.
// 	 */
// 	public java.util.List<String> getWordsWithPrefix(String prefix) {
// 		java.util.List<String> result = new java.util.ArrayList<>();
// 		if (prefix == null || prefix.length() < 3) {
// 			return result;
// 		}
// 		TrieNode node = root;
// 		for (char ch : prefix.toCharArray()) {
// 			node = node.children.get(ch);
// 			if (node == null) {
// 				return result;
// 			}
// 		}
// 		// If we have precomputed list, use it directly
// 		if (node.wordsFromHere != null) {
// 			result.addAll(node.wordsFromHere);
// 		} else {
// 			collectWords(node, new StringBuilder(prefix), result);
// 		}
// 		return result;
// 	}

// 	private void collectWords(TrieNode node, StringBuilder current, java.util.List<String> acc) {
// 		if (node.isWord) {
// 			acc.add(current.toString());
// 		}
// 		for (java.util.Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
// 			current.append(entry.getKey());
// 			collectWords(entry.getValue(), current, acc);
// 			current.setLength(current.length() - 1); // backtrack
// 		}
// 	}

// }
