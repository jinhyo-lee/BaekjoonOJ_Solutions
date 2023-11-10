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

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            int p = s.indexOf('@'), i = s.indexOf('+');

            set.add(s.substring(0, i == -1 ? p : i).replace(".", "") + s.substring(p));
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

}
