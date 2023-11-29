import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        arr = new int[(n = read()) - 1];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        int i = 1;
        while (!generate(i, sb = new StringBuilder(), new boolean[n + 1]) && i < arr[0]) i++;

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean generate(int a, StringBuilder sb, boolean[] visit) {
        sb.append(a).append(" ");
        visit[a] = true;

        for (int b : arr) {
            if ((a = b - a) <= 0 || a > n || visit[a]) return false;
            sb.append(a).append(" ");
            visit[a] = true;
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
