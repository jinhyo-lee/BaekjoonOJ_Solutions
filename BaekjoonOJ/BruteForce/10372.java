import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(search(read()));
        bw.flush();
    }

    private static String search(int n) {
        for (int i = 0; i < 24; i++)
            for (int h = count(i), j = 0; j < 60; j++)
                if (h + count(j) == n) return (i < 10 ? "0" + i : i) + ":" + (j < 10 ? "0" + j : j);

        return "Impossible";
    }

    private static int count(int n) {
        int cnt = n < 10 ? 6 : 0;
        do cnt += arr[n % 10]; while ((n /= 10) > 0);

        return cnt;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
