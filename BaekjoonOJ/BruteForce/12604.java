import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        for (int t = 1; t <= n; t++) {
            int c = read();
            int[] arr = new int[read()];
            for (int i = 0; i < arr.length; i++) arr[i] = read();

            sb.append("Case #").append(t).append(": ").append(find(c, arr)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String find(int c, int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++) if (arr[i] + arr[j] == c) return ++i + " " + ++j;

        return "";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
