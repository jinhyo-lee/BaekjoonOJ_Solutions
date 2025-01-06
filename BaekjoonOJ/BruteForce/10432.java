import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int p = read();
        while (p-- > 0) {
            int t = read();
            for (int i = 0; i < 12; i++) arr[i] = read();

            int cnt = 0;
            for (int i = 0; i < 12; i++) for (int j = i + 2; j < 12; j++) if (isIsland(i, j)) cnt++;

            sb.append(t).append(" ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isIsland(int i, int j) {
        int max = Math.max(arr[i], arr[j]);
        for (int k = i + 1; k < j; k++) if (arr[k] <= max) return false;

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
