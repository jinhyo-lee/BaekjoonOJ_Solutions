import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = (int) read(), k = (int) read();
        long[] arr = new long[n];

        arr[0] = read();
        for (int i = 1; i < n; i++) arr[i] = arr[i - 1] + read();

        Arrays.sort(arr);

        long sum = 0;
        while (k-- > 0) sum += arr[--n];

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
