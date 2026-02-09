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

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = br.readLine();

            int i = 0, j = (n + 1) / 2, k = 0;
            while (k < n) sb.append((k++ & 1) == 0 ? arr[i++] : arr[j++]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
