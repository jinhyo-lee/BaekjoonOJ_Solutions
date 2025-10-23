import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        int n = read() * read();

        for (int i = 0; i < arr.length; i++) arr[i] = read();
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = arr.length - 1; i > -1; i--, cnt++) if ((n -= arr[i]) < 1) break;

        bw.write(n < 1 ? String.valueOf(cnt + 1) : "STRESS");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
