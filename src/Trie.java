// Trie.java by Sohum Berry edited from SpellCheck
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('_', false);
    }

    public void insert(int temp) {
        // Inserts a string into its appropriate spot in the trie
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child;
            if (currentNode.getChildren()[c] == null) {
                // If that letter does not exist on the chain... make the node
                child = new TrieNode(c, (i == word.length() - 1));
                currentNode.addChild(child);
            } else {
                // If the next letter exists on the chain...move to the node
                child = currentNode.getChildren()[c];
                if (i == word.length() - 1) {
                    child.setWordEnd(true);
                }
            }
            currentNode = child;
        }
    }

    public boolean lookup(String word) {
        // Returns false if the word is not in the trie
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (currentNode.getChildren()[c] != null) {
                // Word is so far in the dictionary
                currentNode = currentNode.getChildren()[currentNode.getChildren()[c].getLetter()];
                if (i == word.length() - 1) {
                    // If the end of the word isn't the end of any words in the dictionary
                    return currentNode.isWordEnd();
                }
            } else {
                // Word is not in the dictionary
                return false;
            }
        }
        return false;
    }

    public boolean isValidPrefix(String word) {
        // Returns true if the given string appears in the Trie at all
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (currentNode.getChildren()[c] != null) {
                // Word is so far in the dictionary
                currentNode = currentNode.getChildren()[currentNode.getChildren()[c].getLetter()];
                if (i == word.length() - 1) {
                    // The word exists; status of the square doesn't matter
                    return true;
                }
            } else {
                // Word is not in the dictionary
                return false;
            }
        }
        // Empty string counts as a valid prefix
        return true;
    }

    public void removeWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (currentNode.getChildren()[c] != null) {
                // Word is so far in the dictionary
                currentNode = currentNode.getChildren()[currentNode.getChildren()[c].getLetter()];
                if (i == word.length() - 1) {
                    // Set the found word to false in order to remove it from the dictionary
                    currentNode.setWordEnd(false);
                    // If no word is found, do nothing
                }
            }
        }
    }
}