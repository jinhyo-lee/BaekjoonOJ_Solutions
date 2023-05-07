import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] row = new long[n], col = new long[m];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int height = Integer.parseInt(st.nextToken());
                sum += height;

                row[i] = Math.max(row[i], height);
                col[j] = Math.max(col[j], height);
            }
        }

        sum -= LongStream.concat(Arrays.stream(row), Arrays.stream(col)).distinct().sum();

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
