import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            br.readLine();
            Collections.addAll(set, br.readLine().split(" "));
            Collections.addAll(set, br.readLine().split(" "));

            sb.append(set.size()).append('\n');
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
