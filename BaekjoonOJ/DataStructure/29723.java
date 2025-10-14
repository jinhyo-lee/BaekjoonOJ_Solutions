import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String s = br.readLine();
            int i = s.indexOf(' ');
            map.put(s.substring(0, i), Integer.parseInt(s.substring(i + 1)));
        }

        int sum = 0;
        for (int i = 0; i < k; i++) sum += map.remove(br.readLine());

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        int min = sum, i = 0, j = list.size() - 1;
        while (m-- > k) {
            min += list.get(i++);
            sum += list.get(j--);
        }

        bw.write(min + " " + sum);
        bw.flush();
    }

}
