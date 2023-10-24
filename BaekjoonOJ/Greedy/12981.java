import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = read();
        Arrays.sort(arr);

        int cnt = arr[0];
        arr[1] -= cnt;
        arr[2] -= cnt;

        cnt += arr[1] / 3 + arr[2] / 3;
        arr[1] %= 3;
        arr[2] %= 3;

        if ((arr[1] + arr[2] == 3) || (arr[1] + arr[2] == 4)) cnt += 2;
        else if ((arr[1] + arr[2] == 1) || (arr[1] + arr[2] == 2)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
