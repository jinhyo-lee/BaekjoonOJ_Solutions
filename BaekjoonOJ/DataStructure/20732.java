import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String res = "correct";
        int n = Integer.parseInt(br.readLine());
        for (int t = 1; t <= n; t++) {
            String s = br.readLine();
            int i = s.indexOf("-");
            if (i == 0) set.add(s.substring(3));
            else if (contains(s.substring(0, i - 1))) set.add(s.substring(i + 3));
            else {
                res = String.valueOf(t);
                break;
            }
        }

        bw.write(res);
        bw.flush();
    }

    private static boolean contains(String s) {
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) if (!set.contains(st.nextToken())) return false;

        return true;
    }

}
