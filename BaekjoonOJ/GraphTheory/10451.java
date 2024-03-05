import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read();
            arr = new int[n];
            visit = new boolean[n];

            for (int i = 0; i < n; i++) arr[i] = read() - 1;

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    dfs(i);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int src) {
        if (visit[src]) return;
        visit[src] = true;

        dfs(arr[src]);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
