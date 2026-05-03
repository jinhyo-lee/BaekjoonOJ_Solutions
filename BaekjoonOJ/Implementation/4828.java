import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Pattern p = Pattern.compile("<([0-9a-z]+)>|<[0-9a-z]+/>|</([0-9a-z]+)>|([<>])");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()) != null) sb.append(isValid(s) ? "valid\n" : "invalid\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isValid(String s) {
        Stack<String> stk = new Stack<>();
        Matcher m = p.matcher(s);
        while (m.find()) {
            if (m.group(3) != null) return false;
            if (m.group(1) != null) stk.push(m.group(1));
            else if (m.group(2) != null) if (stk.isEmpty() || !stk.pop().equals(m.group(2))) return false;
        }
        if (!stk.isEmpty()) return false;

        return !s.replaceAll("&lt;|&gt;|&amp;", "").replaceAll("&x([0-9A-Fa-f]{2})+;", "").contains("&");
    }

}
