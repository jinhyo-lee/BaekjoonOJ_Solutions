import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node cur = root;
            while (k-- > 0) cur = insert(cur.child, st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        print(root, 0, sb);

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Node {
        Map<String, Node> child = new TreeMap<>();
    }

    private static Node insert(Map<String, Node> child, String s) {
        if (!child.containsKey(s)) child.put(s, new Node());
        return child.get(s);
    }

    private static void print(Node node, int depth, StringBuilder sb) {
        for (Entry<String, Node> e : node.child.entrySet()) {
            for (int i = 0; i < depth; i++) sb.append("--");
            sb.append(e.getKey()).append('\n');
            print(e.getValue(), depth + 1, sb);
        }
    }

}
