import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        while (n-- > 0)
            trie.insert(br.readLine());

        int cnt = 0;
        while (m-- > 0) {
            if (trie.startWith(br.readLine()))
                cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isWord;

        public TrieNode() {
            child = new HashMap<>();
            isWord = false;
        }
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.child.computeIfAbsent(c, t -> new TrieNode());
                node = node.child.get(c);
            }

            node.isWord = true;
        }

        public boolean startWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.child.containsKey(c))
                    return false;

                node = node.child.get(c);
            }

            return true;
        }
    }

}
