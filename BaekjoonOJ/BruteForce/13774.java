import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()).charAt(0) != '#') sb.append(isPossible(s)).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static String isPossible(String s) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s).replace(i, i + 1, "");
            if (isPalindrome(sb)) return sb.toString();
        }

        return "not possible";
    }

    private static boolean isPalindrome(StringBuilder s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return true;
    }

}
