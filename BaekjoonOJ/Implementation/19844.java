import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " -");
        int cnt = 0;
        while (st.hasMoreTokens()) cnt += count(st.nextToken());

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int count(String s) {
        int i = s.indexOf('\'');
        if (i == -1) return 1;

        if (i == 1 && s.length() > 2 && isConsonant(s.charAt(0)) && isVowel(s.charAt(2))) return 2;
        else if (i == 2 && s.length() > 3 && s.charAt(0) == 'q' && s.charAt(1) == 'u' && isVowel(s.charAt(3))) return 2;

        return 1;
    }

    private static boolean isConsonant(char c) {
        return c == 'c' || c == 'j' || c == 'n' || c == 'm' || c == 't' || c == 's' || c == 'l' || c == 'd';
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'h';
    }

}
