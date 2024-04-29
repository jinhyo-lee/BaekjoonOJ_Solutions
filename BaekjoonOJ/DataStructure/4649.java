import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();
        String line;
        while (!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken()), cnt = 0;
            String s = st.nextToken();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (set.contains(c)) set.remove(c);
                else if (set.size() < n) set.add(c);
                else cnt++;
            }

            if (cnt == 0) sb.append("All customers tanned successfully.\n");
            else sb.append(cnt / 2).append(" customer(s) walked away.\n");
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
