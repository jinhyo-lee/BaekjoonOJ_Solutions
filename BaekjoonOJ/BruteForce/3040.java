import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) sum += arr[i] = read();

        find(arr, sum, sb);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void find(int[] arr, int sum, StringBuilder sb) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (arr[i] + arr[j]) != 100) continue;
                for (int k = 0; k < 9; k++) if (k != i && k != j) sb.append(arr[k]).append('\n');
                return;
            }
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
