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

        int m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= m; i++) {
            StringBuilder tmp = new StringBuilder();
            String s;
            while (!(s = br.readLine()).equals("-1")) if (!set.contains(s)) tmp.append(s).append("\n");

            sb.append("Email ").append(i).append(" is ");
            if (tmp.length() == 0) sb.append("spelled correctly.\n");
            else sb.append("not spelled correctly.\n").append(tmp);
        }

        sb.append("End of Output");
        bw.write(sb.toString());
        bw.flush();
    }

}
