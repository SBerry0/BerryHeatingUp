// TrieNode.java by Sohum Berry from SpellCheck
public class TrieNode {
    int NUM_CHARACTERS = 181;
    private int num;
    private TrieNode[] children;
    private boolean isWordEnd;

    public TrieNode(int num, boolean isWordEnd) {
        this.num = num;
        children = new TrieNode[NUM_CHARACTERS];
        this.isWordEnd = isWordEnd;
    }

    // Setters
    public void addChild(TrieNode c) {
        children[c.getLetter()] = c;
    }
    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }

    // Getters
    public boolean isWordEnd() {
        return isWordEnd;
    }

    public int getLetter() { return num; }

    public TrieNode[] getChildren() {
        return children;
    }

    public String toString() {
        return ""+num;
    }
}
