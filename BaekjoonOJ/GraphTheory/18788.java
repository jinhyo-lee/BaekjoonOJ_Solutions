import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int a1, a2, b1, b2;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), k = read();
        a1 = read();
        a2 = read();
        b1 = read();
        b2 = read();

        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int nxt = i, cnt = 1;
            while ((nxt = swap(nxt)) != i) cnt++;

            int rtn = k % cnt;
            while (rtn-- > 0) nxt = swap(nxt);

            arr[nxt] = i;
        }

        for (int i = 1; i <= n; i++) sb.append(arr[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int swap(int i) {
        if (a1 <= i && i <= a2) i = a1 + a2 - i;
        if (b1 <= i && i <= b2) i = b1 + b2 - i;

        return i;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
