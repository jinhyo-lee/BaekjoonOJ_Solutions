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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int sub = 10000;
        while (n-- > 0) {
            arr[n] = Integer.parseInt(st.nextToken());
            sub = Math.min(sub, arr[n]);
        }

        int min = Integer.MAX_VALUE;
        while (true) {
            int sum = 0;
            for (int i : arr)
                sum += Math.abs(i - sub);

            if (sum < min) {
                min = sum;
                sub++;
            } else
                break;
        }

        bw.write(String.valueOf(sub - 1));
        bw.flush();
    }

}
