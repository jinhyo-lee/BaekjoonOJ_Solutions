import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), k = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();
        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < n && arr[i] < 0; i += k) sum -= arr[i];
        for (int i = n - 1; i >= 0 && arr[i] > 0; i -= k) sum += arr[i];

        bw.write(String.valueOf(sum * 2));
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
