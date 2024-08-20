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
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) set.add(br.readLine());

        boolean b = false;
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String s = br.readLine();
            if (set.contains(s)) {
                b = !b;
                sb.append(b ? "Opened by " : "Closed by ");
            } else sb.append("Unknown ");
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
