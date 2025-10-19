import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(find(Integer.parseInt(br.readLine()), br.readLine())));
        bw.flush();
    }

    private static int find(int n, String s) {
        int m = n, cnt = 0;
        do for (int i = 0; i + n <= m; i++) if (isAna(s, i, i + n)) cnt++; while (--n >= 3);

        return cnt;
    }

    private static boolean isAna(String s, int i, int j) {
        if (s.charAt(i) != 'A' || s.charAt(--j) != 'A') return false;

        int n = 0;
        while (++i < j) if (s.charAt(i) == 'A' || s.charAt(i) == 'N' && ++n > 1) return false;

        return n == 1;
    }

}
