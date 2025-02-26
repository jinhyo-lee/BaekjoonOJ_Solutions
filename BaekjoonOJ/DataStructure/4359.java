import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());

        Map<Integer, boolean[]> map = new HashMap<>();
        for (int i = 1; i <= p; i++) map.put(i, new boolean[t]);

        String s;
        while ((s = br.readLine()) != null) {
            st = new StringTokenizer(s);
            map.get(Integer.parseInt(st.nextToken()))[Integer.parseInt(st.nextToken()) - 1] = true;
        }

        Set<String> set = new HashSet<>();
        for (boolean[] v : map.values()) set.add(toString(v));

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    private static String toString(boolean[] arr) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : arr) sb.append(b ? '.' : ' ');

        return sb.toString();
    }

}
