import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().replace(" ", ""));

        int tmp = n;
        for (int i = 0; i < 3; i++)
            n = Math.min(n, tmp = 1000 * (tmp % 10) + tmp / 10);

        int cnt = 1;
        for (int i = 1111; i < n; i++)
            if (isClockNumber(i)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean isClockNumber(int n) {
        int tmp = n;
        for (int i = 0; i < 3; i++)
            if (tmp % 10 == 0 || (tmp = 1000 * (tmp % 10) + tmp / 10) < n) return false;

        return true;
    }

}
