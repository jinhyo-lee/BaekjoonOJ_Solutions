import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n], b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = b[i] = toInt(st.nextToken());
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            if (a[n - i - 1] == b[i]) continue;
            sb.append(toString(a[n - i - 1])).append(' ').append(toString(b[i]));
            break;
        }

        bw.write(sb.length() == 0 ? "OK\n" : "KO\n");
        bw.write(sb.toString());
        bw.flush();
    }

    private static int toInt(String s) {
        char c = s.charAt(0);
        return (c == 'B' ? 40000 : c == 'S' ? 30000 : c == 'G' ? 20000 : c == 'P' ? 10000 : 0) + Integer.parseInt(s.substring(1));
    }

    private static String toString(int i) {
        return (i >= 40000 ? "B" : i >= 30000 ? "S" : i >= 20000 ? "G" : i >= 10000 ? "P" : "D") + i % 10000;
    }

}
