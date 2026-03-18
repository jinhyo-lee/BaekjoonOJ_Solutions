import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = init();
        int n = read();
        while (n-- > 0) sb.append(arr[read()]).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] init() {
        int[] arr = new int[46];
        arr[0] = arr[1] = 1;
        for (int i = 2; i < 46; i++) arr[i] = arr[i - 1] + arr[i - 2];

        return arr;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
