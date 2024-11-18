import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 21; i++) arr[i] = i;
        for (int i = 0; i < 10; i++) reverse(read(), read());
        for (int i = 1; i < 21; i++) sb.append(arr[i]).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void reverse(int a, int b) {
        while (a < b) {
            int tmp = arr[a];
            arr[a++] = arr[b];
            arr[b--] = tmp;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
