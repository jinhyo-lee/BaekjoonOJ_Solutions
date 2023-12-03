import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[41];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < 41; i++) arr[i] = arr[i - 1] + arr[i - 2];

        int n;
        while ((n = read()) != 0) sb.append(arr[n]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
