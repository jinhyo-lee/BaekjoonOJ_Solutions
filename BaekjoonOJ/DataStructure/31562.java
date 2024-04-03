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
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, List<String>> map = new HashMap<>();
        while (n-- > 0) {
            String[] arr = br.readLine().split(" ", 3);
            String key = arr[2].substring(0, 5);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(arr[1]);
            map.put(key, list);
        }

        while (m-- > 0) {
            List<String> list = map.getOrDefault(br.readLine(), new ArrayList<>());
            sb.append(list.isEmpty() ? "!\n" : list.size() == 1 ? list.get(0) + "\n" : "?\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
