import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int p = read(), q = read();
        boolean[] arr = new boolean[read() + 1];
        for (int i = p; i < arr.length; i += p) arr[i] = true;

        bw.write(compare(arr, q));
        bw.flush();
    }

    private static String compare(boolean[] arr, int q) {
        for (int i = q; i < arr.length; i += q) if (arr[i]) return "yes";

        return "no";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
