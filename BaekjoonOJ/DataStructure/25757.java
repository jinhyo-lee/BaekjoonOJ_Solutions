import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(' ')));
        while (n-- > 0) set.add(br.readLine());

        bw.write(String.valueOf(set.size() / divisor(s.charAt(s.length() - 1))));
        bw.flush();
    }

    private static int divisor(char c) {
        return c == 'Y' ? 1 : c == 'F' ? 2 : 3;
    }

}
