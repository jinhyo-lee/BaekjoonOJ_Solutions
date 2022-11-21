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

        bw.write(String.valueOf(getCount(n)));
        bw.flush();
    }

    private static int getCount(int n) {
        int cnt = 99;

        if (n < 100)
            return n;
        else {
            for (int i = 100; i <= n; i++) {
                int h = i / 100;
                int t = (i / 10) % 10;
                int o = i % 10;

                if (t - h == o - t)
                    cnt++;
            }
        }

        return cnt;
    }

}
