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

        long[] arr = new long[n];
        while (n-- > 0) arr[n] = Long.parseLong(st.nextToken());

        long v = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (v < arr[i]) v = arr[i];
            else if (v % arr[i] != 0) v = arr[i] * (v / arr[i] + 1L);
        }

        bw.write(String.valueOf(v));
        bw.flush();
    }

}
