import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {

    static Pattern ptn = Pattern.compile("[aeiou]");
    static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals("end"))
            sb.append("<").append(s).append("> is ").append(isVerified(s) ? "" : "not ").append("acceptable.\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isVerified(String s) {
        if (!ptn.matcher(s).find()) return false;

        char a = s.charAt(0), b;
        int cnt = 0;
        for (int i = 1; i < s.length(); i++, a = b) {
            b = s.charAt(i);
            if ((set.contains(a) && set.contains(b)) || (!set.contains(a) && !set.contains(b))) cnt++;
            else cnt = 0;

            if (cnt == 2 || (a == b && a != 'e' && a != 'o')) return false;
        }

        return true;
    }

}
