import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        while (n-- > 0) {
            int[] arr = new int[read()];
            for (int i = 0; i < arr.length; i++) arr[i] = read();
            sb.append(find(arr) + 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int find(int[] arr) {
        for (int i = arr.length - 2; i >= 1; i--) if (arr[i] - arr[i - 1] != 1 && arr[i + 1] - arr[i] != 1) return i;
        return 0;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
