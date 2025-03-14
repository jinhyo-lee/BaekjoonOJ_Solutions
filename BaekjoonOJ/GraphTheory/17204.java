import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        int k = read();
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        bw.write(String.valueOf(search(arr, k)));
        bw.flush();
    }

    private static int search(int[] arr, int k) {
        boolean[] visit = new boolean[arr.length];
        int i = 0, m = 1;
        while (arr[i] != k) {
            if (visit[i = arr[i]]) return -1;
            visit[i] = true;
            m++;
        }

        return m;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
