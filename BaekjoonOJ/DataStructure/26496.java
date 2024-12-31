import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<String> set = new LinkedHashSet<>();
        String s;
        while ((s = br.readLine()) != null) {
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j + i <= s.length(); j++) {
                    String sub = s.substring(j, j + i);
                    if (isPalindrome(sub)) set.add(sub);
                }
            }

            sb.append(set.size()).append(" - ");
            for (String p : set) sb.append("\"").append(p).append("\" ");
            sb.append("\n");
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isPalindrome(String s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return true;
    }

}
