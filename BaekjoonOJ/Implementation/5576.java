import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) arr[i] = read();
        int w = sum(arr);
        for (int i = 0; i < 10; i++) arr[i] = read();

        bw.write(w + " " + sum(arr));
        bw.flush();
    }

    private static int sum(int[] arr) {
        Arrays.sort(arr);
        return arr[9] + arr[8] + arr[7];
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
