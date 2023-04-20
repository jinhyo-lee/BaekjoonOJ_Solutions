import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        arr = new int[m + 1];
        visit = new boolean[m + 1];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (arr[b] == 0)
                arr[b] = a;
        }

        dfs(p);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int idx) {
        if (visit[idx]) {
            cnt = -1;
            return;
        }

        if (arr[idx] > 0) {
            visit[idx] = true;
            cnt++;
            dfs(arr[idx]);
        }
    }

}
