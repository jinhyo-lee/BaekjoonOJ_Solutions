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

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        while (k-- > 0)
            arr[k] = Integer.parseInt(br.readLine());

        long low = 0, high = Integer.MAX_VALUE + 1L;
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (long i : arr)
                sum += i / mid;

            if (sum < n) high = mid - 1;
            else low = mid + 1;
        }

        bw.write(String.valueOf(high));
        bw.flush();
    }

}
