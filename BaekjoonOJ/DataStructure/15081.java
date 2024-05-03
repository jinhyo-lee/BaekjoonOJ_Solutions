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
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) sb.append(choose(br.readLine())).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static String choose(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int m = Integer.parseInt(st.nextToken());
        while (m-- > 0) if (set.add(s = st.nextToken())) return s;

        return s;
    }

}
