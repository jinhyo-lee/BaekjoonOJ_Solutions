import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String s;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();

        int n = 0;
        while (n++ < 30001) if (contains(String.valueOf(n))) break;

        bw.write(String.valueOf(n));
        bw.flush();
    }

    private static boolean contains(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == s.charAt(idx)) idx++;
            if (idx == s.length()) return true;
        }

        return false;
    }

}
