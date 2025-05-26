import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        int a = 0, b = 0;
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s.replaceAll("[^a-zA-Z]", " "));
            while (st.hasMoreTokens()) {
                if ((s = st.nextToken()).equals("BULLSHIT")) {
                    a += set.size();
                    set.clear();
                    b++;
                } else set.add(s.toLowerCase());
            }
        }

        int gcd = gcd(a, b);
        bw.write(a / gcd + " / " + b / gcd);
        bw.flush();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
