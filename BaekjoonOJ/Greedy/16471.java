import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer a = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());

        int[][] arr = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = Integer.parseInt(a.nextToken());
            arr[1][i] = Integer.parseInt(b.nextToken());
        }

        for (int[] row : arr)
            Arrays.sort(row);

        int cnt = 0, idx = 0, win = (n + 1) / 2;
        for (int i = 0; i < n && cnt < win; i++) {
            if (arr[0][idx] < arr[1][i]) {
                cnt++;
                idx++;
            }
        }

        bw.write(cnt < win ? "NO" : "YES");
        bw.flush();
    }

}
