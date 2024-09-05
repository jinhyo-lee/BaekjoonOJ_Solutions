import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = read();
        int[] arr = new int[n];
        while (n-- > 0) arr[n] = read();

        for (int i = 0; i < arr.length; i++) for (int j = i + 1; j < arr.length; j++) if (arr[i] + arr[j] == k) n++;

        bw.write(String.valueOf(n + 1));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
