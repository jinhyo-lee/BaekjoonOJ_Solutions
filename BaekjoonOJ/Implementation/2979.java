import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] cnt = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {0, read(), read(), read()};
        for (int i = 0; i < 3; i++) count(read(), read());

        int sum = 0;
        for (int i : cnt) sum += arr[i] * i;

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static void count(int i, int j) {
        while (i < j) cnt[i++]++;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
