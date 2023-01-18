import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringTokenizer tmp;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        int[] dp = new int[100];

        st = new StringTokenizer(br.readLine());
        tmp = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(tmp.nextToken());
            for (int j = 99; j >= arr[i][0]; j--)
                dp[j] = Math.max(dp[j - arr[i][0]] + arr[i][1], dp[j]);
        }

        bw.write(String.valueOf(dp[99]));
        bw.flush();
    }

}
