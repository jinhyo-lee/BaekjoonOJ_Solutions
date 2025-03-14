import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[read() + 1];
        for (int i = 1; i < arr.length; i++) arr[i] = i;

        int m = read();
        while (m-- > 0) {
            int i = read(), j = read(), k = read(), idx = 0;
            int[] tmp = new int[j - i + 1];
            for (int l = k; l <= j; l++) tmp[idx++] = arr[l];
            for (int l = i; l < k; l++) tmp[idx++] = arr[l];
            System.arraycopy(tmp, 0, arr, i, tmp.length);
        }

        for (int i = 1; i < arr.length; i++) sb.append(arr[i]).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
