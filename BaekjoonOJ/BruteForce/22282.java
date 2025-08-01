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

        bw.write(String.valueOf(find(arr)));
        bw.flush();
    }

    private static int find(int[] arr) {
        for (int i = 0; i < arr.length; i++) if (arr[arr.length - i - 1] <= i) return i;

        return arr.length;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
