import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, List<String>> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String root = st.nextToken();

            List<String> node = new ArrayList<>();
            node.add(st.nextToken());
            node.add(st.nextToken());

            tree.put(root, node);
        }

        preorder("A");
        sb.append("\n");

        inorder("A");
        sb.append("\n");

        postorder("A");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void preorder(String node) {
        if (node.equals("."))
            return;

        sb.append(node);
        preorder(tree.get(node).get(0));
        preorder(tree.get(node).get(1));
    }

    private static void inorder(String node) {
        if (node.equals("."))
            return;

        inorder(tree.get(node).get(0));
        sb.append(node);
        inorder(tree.get(node).get(1));
    }

    private static void postorder(String node) {
        if (node.equals("."))
            return;

        postorder(tree.get(node).get(0));
        postorder(tree.get(node).get(1));
        sb.append(node);
    }

}
