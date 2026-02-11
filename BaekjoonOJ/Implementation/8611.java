import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BigInteger n = new BigInteger(br.readLine());
        String s;
        for (int i = 2; i < 11; i++)
            if (isPalindrome(s = n.toString(i))) sb.append(i).append(' ').append(s).append('\n');

        bw.write(sb.length() > 0 ? sb.toString() : "NIE");
        bw.flush();
    }

    private static boolean isPalindrome(String s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return true;
    }

}
