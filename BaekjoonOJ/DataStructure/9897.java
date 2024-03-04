import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());

        Map<String, List<Integer>> map = new HashMap<>();
        while (g-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            do list.add(a); while (((a += d) <= l));

            map.put(s, list);
        }

        boolean[] arr = new boolean[l + 1];
        while (r-- > 0) for (int i : map.get(br.readLine())) arr[i] = !arr[i];

        int cnt = 0;
        for (boolean b : arr) if (b) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
