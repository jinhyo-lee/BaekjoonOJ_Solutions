import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(calc(read(), read()));
        bw.flush();
    }

    private static String calc(int a, int b) {
        List<Integer> list = new ArrayList<>();
        while (a > 0 || b > 0) {
            list.add(a % 10 + b % 10);
            a /= 10;
            b /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) sb.append(list.get(i));

        return sb.toString();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
