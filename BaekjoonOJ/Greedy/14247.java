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

        StringTokenizer h = new StringTokenizer(br.readLine());
        StringTokenizer a = new StringTokenizer(br.readLine());

        long sum = 0L;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(h.nextToken());
            arr[i] = Integer.parseInt(a.nextToken());
        }

        Arrays.sort(arr);

        while (n-- > 0)
            sum += (long) arr[n] * n;

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
