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

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (k < n) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            int[] dist = new int[n - 1];
            for (int i = 0; i < n - 1; i++)
                dist[i] = arr[i + 1] - arr[i];
            Arrays.sort(dist);

            int sum = 0;
            for (int i = 0; i < n - k; i++)
                sum += dist[i];

            bw.write(String.valueOf(sum));
        } else
            bw.write("0");

        bw.flush();
    }

}
