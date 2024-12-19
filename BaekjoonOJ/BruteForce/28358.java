import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[] visit = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int t = read();
        while (t-- > 0) {
            for (int i = 0; i < 10; i++) visit[i] = read() == 1;

            int cnt = 0;
            for (int i = 1; i <= 12; i++) for (int j = arr[i]; j >= 1; j--) if (!contains(i) && !contains(j)) cnt++;

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean contains(int n) {
        do if (visit[n % 10]) return true; while ((n /= 10) > 0);

        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
