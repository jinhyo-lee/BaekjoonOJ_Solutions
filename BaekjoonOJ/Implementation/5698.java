import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()).charAt(0) != '*') sb.append(isTautogram(s) ? "Y\n" : "N\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isTautogram(String s) {
        StringTokenizer st = new StringTokenizer(s.toLowerCase());
        char c = st.nextToken().charAt(0);
        while (st.hasMoreTokens()) if (c != st.nextToken().charAt(0)) return false;

        return true;
    }

}
