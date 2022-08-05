import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r, x, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        recur(0, Integer.MAX_VALUE, 0, 0, 0);

        bw.write(cnt + "\n");
        bw.flush();
    }

    private static void recur(int sum, int min, int max, int idx, int depth) {
        if (depth >= 2) {
            if (sum >= l && sum <= r && max - min >= x)
                cnt++;
        }

        for (int i = idx; i < n; i++)
            recur(sum + arr[i], Math.min(min, arr[i]), Math.max(max, arr[i]), i + 1, depth + 1);
    }

}
