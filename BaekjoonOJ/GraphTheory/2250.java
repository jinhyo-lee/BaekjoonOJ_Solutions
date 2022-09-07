import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int maxLevel;
    static int row = 1;
    static Node[] nodes;
    static int[] max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];
        max = new int[n + 1];
        min = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
            max[i] = 0;
            min[i] = n;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            nodes[cur].left = left;
            nodes[cur].right = right;

            if (left != -1)
                nodes[left].parent = cur;
            if (right != -1)
                nodes[right].parent = cur;
        }

        for (int i = 1; i <= n; i++) {
            if (nodes[i].parent == -1) {
                inorder(i, 1);
                break;
            }
        }

        int level = 0;
        int maxWidth = 0;
        for (int i = 1; i <= maxLevel; i++) {
            int width = max[i] - min[i] + 1;
            if (maxWidth < width) {
                maxWidth = width;
                level = i;
            }
        }

        bw.write(level + " " + maxWidth);
        bw.flush();
    }

    private static void inorder(int node, int level) {
        Node cur = nodes[node];

        maxLevel = Math.max(maxLevel, level);

        if (cur.left != -1)
            inorder(cur.left, level + 1);

        min[level] = Math.min(min[level], row);
        max[level] = row++;

        if (cur.right != -1)
            inorder(cur.right, level + 1);
    }

    private static class Node {
        int parent, cur, left, right;

        public Node(int cur) {
            this.cur = cur;
            parent = left = right = -1;
        }
    }

}
