import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int k = read();
        for (int t = 1; t <= k; t++) {
            int[] arr = new int[read()];
            for (int i = 0; i < arr.length; i++) arr[i] = read();
            Arrays.sort(arr);

            int max = 0;
            for (int i = 1; i < arr.length; i++) max = Math.max(max, arr[i] - arr[i - 1]);

            sb.append("Class ").append(t).append("\nMax ").append(arr[arr.length - 1]).append(", Min ").append(arr[0]).append(", Largest gap ").append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
