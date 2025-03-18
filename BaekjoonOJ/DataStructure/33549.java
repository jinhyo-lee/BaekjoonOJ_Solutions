import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> map = new HashMap<>();
        String r = br.readLine(), t = br.readLine();
        StringTokenizer d = new StringTokenizer(br.readLine()), e = new StringTokenizer(br.readLine());
        while (d.hasMoreTokens()) map.put(d.nextToken(), e.nextToken());

        bw.write(isValid(map, r, t) ? "VALID" : "STONECOAL");
        bw.flush();
    }

    private static boolean isValid(Map<String, String> map, String r, String t) {
        StringTokenizer a = new StringTokenizer(r.toLowerCase()), b = new StringTokenizer(t.toLowerCase());
        while (a.hasMoreTokens()) if (!clean(a.nextToken()).equals(map.get(clean(b.nextToken())))) return true;

        return false;
    }

    private static String clean(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j && !Character.isLetter(s.charAt(i))) i++;
        while (j >= i && !Character.isLetter(s.charAt(j))) j--;

        return s.substring(i, j + 1);
    }

}
