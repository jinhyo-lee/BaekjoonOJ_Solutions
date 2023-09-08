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
        StringBuilder sb = new StringBuilder();

        Set<String> set = new HashSet<>();

        int t = 0, n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            while (n-- > 0) set.add(br.readLine());

            sb.append("Week ").append(++t).append(" ").append(set.size()).append("\n");
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
