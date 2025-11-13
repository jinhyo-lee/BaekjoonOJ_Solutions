import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), k = read();
        int[] arr = new int[n * n + 1];
        for (int i = 2; i < arr.length; i++) for (int j = i; j < arr.length; j += i) arr[j]++;

        for (int i = 1; i < arr.length; i++) sb.append(arr[i] < k ? '*' : '.').append(i % n != 0 ? "" : '\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
