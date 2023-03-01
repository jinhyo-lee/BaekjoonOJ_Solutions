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

public class Main {

    static int k;
    static char[] src, tgt;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = new String[3];
        for (int i = 0; i < 3; i++)
            input[i] = br.readLine();

        k = Integer.parseInt(br.readLine());
        tgt = new char[k];

        map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            src = input[i].toCharArray();
            recur(0, 0);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            if (map.get(key) >= 2)
                sb.append(key).append("\n");
        }

        bw.write(sb.length() > 0 ? sb.toString() : "-1");
        bw.flush();
    }

    private static void recur(int depth, int idx) {
        if (idx == k) {
            String perm = String.valueOf(tgt);

            map.putIfAbsent(perm, 0);
            map.put(perm, map.get(perm) + 1);
            return;
        }

        for (int i = depth; i < src.length; i++) {
            tgt[idx] = src[i];
            recur(i + 1, idx + 1);
        }
    }

}
