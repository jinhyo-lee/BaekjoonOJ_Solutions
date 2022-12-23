import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        int n = 1;
        int cnt = 0;

        while (n < k)
            n *= 2;

        bw.write(n + " ");

        while (k > 0) {
            if (k >= n)
                k -= n;
            else {
                n /= 2;
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
