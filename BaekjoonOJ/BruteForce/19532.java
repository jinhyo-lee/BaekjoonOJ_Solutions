import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(find(read(), read(), read(), read(), read(), read()));
        bw.flush();
    }

    private static String find(int a, int b, int c, int d, int e, int f) {
        for (int i = -999; i < 1000; i++)
            for (int j = -999; j < 1000; j++) if (a * i + b * j == c && d * i + e * j == f) return i + " " + j;

        return "";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
