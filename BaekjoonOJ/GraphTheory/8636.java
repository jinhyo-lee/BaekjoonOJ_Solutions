import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read() + 1];
        for (int i = 1; i < arr.length; i++) arr[i] = read();

        int cnt = 0, i = 1;
        while (i < arr.length) {
            if (arr[i] == 0) i++;
            else {
                while (arr[i] != 0) {
                    int tmp = arr[i];
                    arr[i] = 0;
                    i = tmp;
                }
                cnt++;
            }
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
