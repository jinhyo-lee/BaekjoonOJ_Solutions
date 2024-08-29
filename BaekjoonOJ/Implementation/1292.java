import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = read(), b = read() + 1, k = 1;
        int[] arr = new int[b];
        for (int i = 1; i < b; i++) for (int j = 0; j < i && k < b; j++) arr[k++] = i;

        int sum = 0;
        for (int i = a; i < b; i++) sum += arr[i];

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
