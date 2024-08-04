import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int m = read(), n = read();
        while (m <= n) count(m++);

        for (int i : arr) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void count(int i) {
        do arr[i % 10]++; while ((i /= 10) > 0);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
