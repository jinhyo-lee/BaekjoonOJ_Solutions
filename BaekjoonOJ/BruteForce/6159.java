import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), s = read();

        int[] arr = new int[n];
        while (n-- > 0) arr[n] = read();

        Arrays.sort(arr);

        int cnt = 0, i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] > s) j--;
            else cnt += j - i++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
