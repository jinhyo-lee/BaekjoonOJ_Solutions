import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();
        Arrays.sort(arr);

        int i = (n + 1) / 2 - 1, j = i + 1;
        while (j < n) sb.append(arr[i--]).append(' ').append(arr[j++]).append(' ');

        bw.write((n & 1) == 0 ? sb.toString() : sb.append(arr[0]).toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
