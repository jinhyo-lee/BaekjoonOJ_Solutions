import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n, m, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read();
        m = read() - 1;

        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read() - 1;

        dfs(m);

        bw.write(cnt++ > 0 ? String.valueOf(cnt) : "0");
        bw.flush();
    }

    private static void dfs(int node) {
        if (arr[node] == m) return;

        cnt++;
        dfs(arr[node]);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
