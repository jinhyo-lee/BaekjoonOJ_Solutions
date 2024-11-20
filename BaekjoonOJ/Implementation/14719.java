import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        read();
        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        int sum = 0;
        for (int i = arr.length - 2; i >= 1; i--) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) l = Math.max(l, arr[j]);
            for (int j = i + 1; j < arr.length; j++) r = Math.max(r, arr[j]);

            if (arr[i] < l && arr[i] < r) sum += Math.min(l, r) - arr[i];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
