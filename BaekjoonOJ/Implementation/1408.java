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

        Time t = new Time(br.readLine());
        int n = calc(new Time(br.readLine())) - calc(t);
        if (n < 0) n += 86400;

        bw.write(String.format("%02d:%02d:%02d", n / 3600, n % 3600 / 60, n % 60));
        bw.flush();
    }

    private static int calc(Time t) {
        return t.h * 3600 + t.m * 60 + t.s;
    }

    private static class Time {
        int h, m, s;

        Time(String s) {
            StringTokenizer st = new StringTokenizer(s, ":");
            this.h = Integer.parseInt(st.nextToken());
            this.m = Integer.parseInt(st.nextToken());
            this.s = Integer.parseInt(st.nextToken());
        }
    }

}
