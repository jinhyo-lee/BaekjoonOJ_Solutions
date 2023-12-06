import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static String[] arr;
    static TrieNode trie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new String[n];

            trie = new TrieNode();
            while (n-- > 0) trie.insert(arr[n] = br.readLine());

            sb.append(isConsistent() ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isConsistent() {
        for (String s : arr) if (trie.contains(s)) return false;

        return true;
    }

    private static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        boolean isWord;

        private void insert(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                node.child.computeIfAbsent(c, t -> new TrieNode());
                node = node.child.get(c);
            }

            node.isWord = true;
        }

        public boolean contains(String s) {
            TrieNode node = this;
            for (char c : s.toCharArray()) {
                if (!node.child.containsKey(c)) return false;
                node = node.child.get(c);
            }

            return !node.child.isEmpty();
        }
    }

}
