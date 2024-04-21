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

        Set<Integer> set = new HashSet<>();

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    sb.append(set.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
                    break;
                case "toggle": {
                    int i = Integer.parseInt(st.nextToken());
                    if (set.contains(i)) set.remove(i);
                    else set.add(i);
                    break;
                }
                case "all": {
                    int i = 0;
                    while (i++ < 20) set.add(i);
                    break;
                }
                default:
                    set.clear();
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
