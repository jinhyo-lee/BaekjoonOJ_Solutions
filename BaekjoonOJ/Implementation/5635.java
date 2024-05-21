import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<Integer, String> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            map.put(combine(st.nextToken(), st.nextToken(), st.nextToken()), s);
        }

        bw.write(map.lastEntry().getValue() + "\n" + map.firstEntry().getValue());
        bw.flush();
    }

    private static int combine(String d, String m, String y) {
        return Integer.parseInt(y + format(m) + format(d));
    }

    private static String format(String s) {
        return (s.length() == 1 ? "0" : "") + s;
    }

}
