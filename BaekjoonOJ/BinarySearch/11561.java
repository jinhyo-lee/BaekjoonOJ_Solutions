import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            long low = 0, high = (long) Math.sqrt(2 * n - 1);
            while (low <= high) {
                long mid = (low + high) / 2;

                if (mid * (mid + 1) / 2 > n) high = mid - 1;
                else low = mid + 1;
            }

            sb.append(high).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
