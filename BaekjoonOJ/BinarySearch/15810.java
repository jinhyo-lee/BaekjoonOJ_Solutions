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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        while (n-- > 0)
            arr[n] = Long.parseLong(st.nextToken());

        long low = 0, high = 1000000000000L;
        while (low <= high) {
            long mid = (low + high) / 2;

            long sum = 0;
            for (long i : arr) {
                sum += mid / i;
                if (sum >= m) break;
            }

            if (sum < m) low = mid + 1;
            else high = mid - 1;
        }

        bw.write(String.valueOf(low));
        bw.flush();
    }

}
