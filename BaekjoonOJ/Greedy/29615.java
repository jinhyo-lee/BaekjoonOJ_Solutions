import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();

        boolean[] flag = new boolean[n + 1];
        for (int i = 0; i < m; i++) flag[read()] = true;

        int i = 0, cnt = 0;
        while (i < m) if (!flag[arr[i++]]) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
