import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        bw.write(String.valueOf(parametricSearch(n)));
        bw.flush();
    }

    private static long parametricSearch(long n) {
        long sqrt = 0, low = 0, high = n;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (Math.pow(mid, 2) >= n) {
                high = mid - 1;
                sqrt = mid;
            } else low = mid + 1;
        }

        return sqrt;
    }

}
