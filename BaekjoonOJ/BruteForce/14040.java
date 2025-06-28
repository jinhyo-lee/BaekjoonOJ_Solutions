import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(find(br.readLine())));
        bw.flush();
    }

    private static int find(String s) {
        int n = s.length();
        do for (int i = 0; i + n <= s.length(); i++) if (isPalindromeRange(s, i, i + n)) return n; while (--n > 1);

        return n;
    }

    private static boolean isPalindromeRange(String s, int i, int j) {
        while (i < --j) if (s.charAt(i++) != s.charAt(j)) return false;

        return true;
    }

}
