import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine(), r = reverse(s);
            if (set.contains(r) || s.equals(r)) {
                bw.write(s.length() + " " + s.charAt(s.length() / 2));
                break;
            }
            set.add(s);
        }

        bw.flush();
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) sb.append(s.charAt(i));

        return sb.toString();
    }

}
