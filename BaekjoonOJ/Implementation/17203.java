import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[read() + 1], sum = new int[arr.length];
        int q = read();
        for (int i = 1; i < arr.length; i++) arr[i] = read();
        for (int i = 2; i < arr.length; i++) sum[i] = sum[i - 1] + Math.abs(arr[i] - arr[i - 1]);

        while (q-- > 0) sb.append(-(sum[read()] - sum[read()])).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
