import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        dfs(0);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void dfs(int cur) {
        if (cur > n) return;
        max = Math.max(max, cur);

        for (int i = 0; i < k; i++)
            dfs(cur * 10 + arr[i]);
    }

}
