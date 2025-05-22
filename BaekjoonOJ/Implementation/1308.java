import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int day = count(read(), read(), read(), read(), read(), read());

        bw.write(day == -1 ? "gg" : "D-" + day);
        bw.flush();
    }

    private static int count(int y, int m, int d, int dy, int dm, int dd) {
        if (dy - y > 1000 || (dy - y == 1000 && m < dm || (m == dm && d <= dd))) return -1;

        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0, l = leap(y);
        while (y != dy || m != dm || d != dd) {
            d++;
            day++;
            if (d > (m != 2 ? arr[m] : arr[m] + l)) {
                d = 1;
                if (m++ == 12) {
                    l = leap(++y);
                    m = 1;
                }
            }
        }

        return day;
    }

    private static int leap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0 ? 1 : 0;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
