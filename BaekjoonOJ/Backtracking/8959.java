import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int S, B;
    static boolean[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = 1;
        while ((arr = new boolean[read()]).length != 0) {
            sb.append("Sequence set ").append(t++).append("\n");
            S = read();
            B = read();
            recur(0, 0, 0);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(int s, int b, int i) {
        if (i == arr.length) {
            print(arr);
            return;
        }

        if (s < S) {
            arr[i] = false;
            recur(s + 1, 0, i + 1);
        }
        if (b < B) {
            arr[i] = true;
            recur(0, b + 1, i + 1);
        }
    }

    private static void print(boolean[] arr) {
        for (boolean b : arr) sb.append(b ? '!' : '*');
        sb.append("\n");
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
