import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 84; i++) {
            int sum = 0;
            for (int j : arr) {
                if (j < i) sum += (i - j) * (i - j);
                else if (j > i + 17) sum += (j - i - 17) * (j - i - 17);
            }

            if (sum > min) break;
            min = sum;
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
