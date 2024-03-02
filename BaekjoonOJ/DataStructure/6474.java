import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<Character> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        init();

        String s;
        while ((s = br.readLine()) != null)
            sb.append(s).append(" -- ").append(define(s.contentEquals(new StringBuilder(s).reverse()), isMirrored(s))).append("\n\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isMirrored(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) if (set.contains(s.charAt(i))) cnt++;

        return cnt == s.length();
    }

    private static String define(boolean p, boolean m) {
        return p && m ? "is a mirrored palindrome." : (p ? "is a palindrome." : (m ? "is a mirrored string." : "is not a palindrome."));
    }

    private static void init() {
        set = new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('H');
        set.add('I');
        set.add('J');
        set.add('L');
        set.add('M');
        set.add('O');
        set.add('S');
        set.add('T');
        set.add('U');
        set.add('V');
        set.add('W');
        set.add('X');
        set.add('Y');
        set.add('Z');
        set.add('1');
        set.add('2');
        set.add('3');
        set.add('5');
        set.add('8');
    }

}
