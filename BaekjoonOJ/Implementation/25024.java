import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int x = read(), y = read();
            sb.append(isHour(x) && isMinute(y) ? "Yes " : "No ").append(isMonth(x) && isDay(x, y) ? "Yes\n" : "No\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isHour(int x) {
        return x > -1 && x < 24;
    }

    private static boolean isMinute(int y) {
        return y > -1 && y < 60;
    }

    private static boolean isMonth(int x) {
        return x > 0 && x < 13;
    }

    private static boolean isDay(int x, int y) {
        return y > 0 && (x == 2 ? y < 30 : x == 4 || x == 6 || x == 9 || x == 11 ? y < 31 : y < 32);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
