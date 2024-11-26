import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Set<String>> X = new HashMap<>(), Y = new HashMap<>();
    static Set<Pair> cnt = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        while (x-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken();
            X.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            X.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }

        int y = Integer.parseInt(br.readLine());
        while (y-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken();
            Y.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            Y.computeIfAbsent(b, k -> new HashSet<>()).add(a);
        }

        int g = Integer.parseInt(br.readLine());
        while (g-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            verify(st.nextToken(), st.nextToken(), st.nextToken());
        }

        bw.write(String.valueOf(cnt.size()));
        bw.flush();
    }

    private static void verify(String a, String b, String c) {
        verifyX(a, b, c);
        verifyX(b, c, a);
        verifyX(c, a, b);
        verifyY(a, b, c);
        verifyY(b, c, a);
        verifyY(c, a, b);
    }

    private static void verifyX(String src, String o1, String o2) {
        for (String s : X.getOrDefault(src, Collections.emptySet())) if (!s.equals(o1) && !s.equals(o2)) add(src, s);
    }

    private static void verifyY(String src, String o1, String o2) {
        Set<String> set = Y.getOrDefault(src, Collections.emptySet());
        if (set.contains(o1)) add(src, o1);
        if (set.contains(o2)) add(src, o2);
    }

    private static void add(String a, String b) {
        cnt.add(a.compareTo(b) < 0 ? new Pair(a, b) : new Pair(b, a));
    }

    private static class Pair {
        String a, b;

        Pair(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return a.equals(p.a) && b.equals(p.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

}
