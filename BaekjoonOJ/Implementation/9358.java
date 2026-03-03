import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        for (int tc = 1; tc <= t; tc++) {
            int n = read();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = read();

            while (n > 2) {
                for (int i = 0; i < n; i++) arr[i] = arr[i] + arr[n - i - 1];
                n = (n + 1) / 2;
            }
            sb.append("Case #").append(tc).append(arr[0] > arr[1] ? ": Alice\n" : ": Bob\n");
        }

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
