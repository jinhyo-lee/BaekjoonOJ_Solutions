import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] tree;
    static int[] parent;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            tree[src].add(dest);
            tree[dest].add(src);
        }

        bfs();

        for (int i = 2; i <= n; i++)
            bw.write(parent[i] + "\n");

        bw.flush();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visit[1] = true;

        while (!q.isEmpty()) {
            int src = q.poll();

            for (int dest : tree[src]) {
                if (!visit[dest]) {
                    visit[dest] = true;
                    parent[dest] = src;
                    q.offer(dest);
                }
            }
        }
    }

}
