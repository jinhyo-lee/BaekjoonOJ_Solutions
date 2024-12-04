import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) arr[i] = read();

        int cnt = 0;
        for (int i = 0; i < 5; i++)
            for (int j = i + 1; j < 5; j++)
                for (int k = j + 1; k < 5; k++) if (isTriangle(arr[i], arr[j], arr[k])) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && c + a > b;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
