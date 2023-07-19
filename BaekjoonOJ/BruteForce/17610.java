import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] weights;
    static boolean[] measurable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        weights = new int[k];
        int sum = 1;
        for (int i = 0; i < k; i++)
            sum += weights[i] = Integer.parseInt(st.nextToken());

        measurable = new boolean[sum];
        dfs(0, 0);

        int cnt = 0;
        for (int i = 1; i < sum; i++)
            if (!measurable[i]) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int weight, int idx) {
        if (idx == k) {
            if (weight > 0) measurable[weight] = true;
            return;
        }

        dfs(weight, idx + 1);
        dfs(weight + weights[idx], idx + 1);
        dfs(weight - weights[idx], idx + 1);
    }

}
