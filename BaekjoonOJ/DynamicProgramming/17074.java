import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), cnt = 0, idx = 0, res = 0;
        int[] arr = new int[n + 2];

        arr[0] = -1000000000;
        arr[n + 1] = 1000000000;
        arr[1] = read();

        for (int i = 2; i <= n; i++) {
            if (arr[i - 1] > (arr[i] = read())) {
                cnt++;
                idx = i;
            }
        }

        if (cnt == 0) res = n;
        else if (cnt == 1) {
            if (arr[idx - 1] <= arr[idx + 1]) res++;
            if (arr[idx - 2] <= arr[idx]) res++;
        }

        bw.write(String.valueOf(res));
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
