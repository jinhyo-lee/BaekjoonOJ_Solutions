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

        int[] arr = new int[n];
        int low = 0, high = 1000000000;

        while (n-- > 0)
            low = Math.max(low, arr[n] = Integer.parseInt(br.readLine()));

        while (low <= high) {
            int mid = (low + high) / 2;

            int sub = mid, cnt = 1;
            for (int i : arr) {
                if (i > sub) {
                    sub = mid;
                    cnt++;
                }
                sub -= i;
            }

            if (cnt > m) low = mid + 1;
            else high = mid - 1;
        }

        bw.write(String.valueOf((low)));
        bw.flush();
    }

}
