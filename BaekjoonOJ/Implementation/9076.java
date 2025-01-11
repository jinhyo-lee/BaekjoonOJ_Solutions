import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) arr[i] = read();
            Arrays.sort(arr);

            int sum = sum(arr);
            sb.append(sum == 0 ? "KIN" : sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int sum(int[] arr) {
        int sum = 0, max = Math.max(arr[0], arr[4]);
        for (int i = 1; i < 4; i++) {
            if (Math.abs(max - arr[i]) > 4) return 0;
            else sum += arr[i];
        }

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
