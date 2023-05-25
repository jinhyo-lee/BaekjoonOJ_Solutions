import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int max = 0, sub = 0, tmp;
        for (int i = n / 2; i <= n; i++) {
            int a = n, b = i, cnt = 2;

            while ((tmp = a - b) >= 0) {
                a = b;
                b = tmp;
                cnt++;
            }

            if (cnt > max) {
                max = cnt;
                sub = i;
            }
        }

        StringBuilder sb = new StringBuilder(max + "\n" + n + " " + sub + " ");
        int a = n, b = sub;

        while ((tmp = a - b) >= 0) {
            a = b;
            b = tmp;
            sb.append(tmp).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
