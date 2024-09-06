import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();

        int max = 1;
        for (int i = 1, j, k; i < n; max = Math.max(max, k - i + 1), i = j + 1) {
            j = i;
            while (j < n && arr[j - 1] < arr[j]) j++;
            k = j;
            while (k < n && arr[k - 1] > arr[k]) k++;
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
