import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();
        Arrays.sort(arr);

        int max = 0;
        for (int i = arr.length - 1, j = 1; i >= 0; i--, j++) max = Math.max(max, arr[i] + j);

        bw.write(String.valueOf(max + 1));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
