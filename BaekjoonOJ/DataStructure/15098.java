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

        bw.write(isDistinct(br.readLine()));
        bw.flush();
    }

    private static String isDistinct(String input) {
        StringTokenizer st = new StringTokenizer(input);
        Set<String> set = new HashSet<>();

        String s;
        while (st.hasMoreTokens()) {
            if (set.contains(s = st.nextToken())) return "no";
            set.add(s);
        }

        return "yes";
    }

}
