import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[2][n];
        for (int i = 0; i < 2; i++)
            map[i] = br.readLine().toCharArray();


        bw.write(bfs() ? "1" : "0");
        bw.flush();
    }

    private static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        int[] dir = {1, -1, k};

        q.offer(new Node(0, 0, 0));
        map[0][0] = '.';

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 3; i++) {
                int line = cur.line;
                int step = cur.step + dir[i];

                if (i == 2) {
                    if (cur.line == 1)
                        line = 0;
                    else
                        line = 1;
                }

                if (step >= n)
                    return true;

                if (step <= cur.time || map[line][step] == '0' || map[line][step] == '.')
                    continue;

                map[line][step] = '.';
                q.offer(new Node(line, step, cur.time + 1));
            }
        }

        return false;
    }

    private static class Node {
        int line, step, time;

        public Node(int line, int step, int time) {
            this.line = line;
            this.step = step;
            this.time = time;
        }
    }

}
