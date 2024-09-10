import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = read();
        while (t-- > 0) {
            sb.append("The bit patterns are\n");
            arr = new int[n = read()];
            recur(read(), 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(int k, int i) {
        if (k < 0 || k > n - i || i == n) {
            if (k == 0) print(arr);
            return;
        }

        arr[i] = 1;
        recur(k - 1, i + 1);
        arr[i] = 0;
        recur(k, i + 1);
    }

    private static void print(int[] arr) {
        for (int i : arr) sb.append(i);
        sb.append("\n");
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
