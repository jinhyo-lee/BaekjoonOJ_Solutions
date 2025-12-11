import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        int l = 1, r = 1, max = arr[0] = read();
        for (int i = 1; i < arr.length; i++) {
            if (max < (arr[i] = read())) {
                max = arr[i];
                l++;
            }
        }

        max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (max < (arr[i])) {
                max = arr[i];
                r++;
            }
        }

        bw.write(l + "\n" + r);
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
