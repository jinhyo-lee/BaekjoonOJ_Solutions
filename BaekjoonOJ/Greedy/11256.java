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
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int cnt = n;
            while (n-- > 0 && j > 0)
                j -= arr[n];

            sb.append(cnt - n - 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
