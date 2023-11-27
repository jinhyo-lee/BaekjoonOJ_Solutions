import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int n, len;
    static String s;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        while (len++ <= n && !isDistinct()) set.clear();

        bw.write(String.valueOf(len));
        bw.flush();
    }

    private static boolean isDistinct() {
        String sub;
        for (int i = 0; i <= n - len; i++, set.add(sub)) if (set.contains(sub = s.substring(i, i + len))) return false;

        return true;
    }

}
