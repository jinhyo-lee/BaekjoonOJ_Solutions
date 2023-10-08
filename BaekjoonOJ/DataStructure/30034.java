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

        addDelim(Integer.parseInt(br.readLine()), br.readLine());
        addDelim(Integer.parseInt(br.readLine()), br.readLine());
        removeDelim(Integer.parseInt(br.readLine()), br.readLine());

        StringBuilder delim = new StringBuilder();
        for (String s : set) delim.append(s).append("|");
        delim.append(" ");

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), delim.toString());
        while (st.hasMoreTokens()) sb.append(st.nextToken()).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void addDelim(int n, String s) {
        StringTokenizer st = new StringTokenizer(s);
        while (n-- > 0) set.add(st.nextToken());
    }

    private static void removeDelim(int n, String s) {
        StringTokenizer st = new StringTokenizer(s);
        while (n-- > 0) set.remove(st.nextToken());
    }

}
