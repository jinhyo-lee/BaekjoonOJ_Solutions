import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (op.equals("I"))
                    map.put(n, map.getOrDefault(n, 0) + 1);
                else {
                    if (map.isEmpty())
                        continue;

                    n = n == 1 ? map.lastKey() : map.firstKey();
                    if (map.get(n) == 1)
                        map.remove(n);
                    else
                        map.put(n, map.get(n) - 1);
                }
            }

            if (map.isEmpty())
                sb.append("EMPTY\n");
            else
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
