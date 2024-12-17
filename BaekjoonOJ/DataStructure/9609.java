import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = init();
        int n = Integer.parseInt(br.readLine());
        for (int t = 1; t <= n; t++) {
            String s = "H" + br.readLine() + "H";
            int sum = 0;
            for (int i = s.length() - 2; i >= 0; i--) sum += map.getOrDefault(s.substring(i, i + 2), 0);
            sb.append("Case ").append(t).append(": ").append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static Map<String, Integer> init() {
        Map<String, Integer> map = new HashMap<>();
        map.put("HP", 103);
        map.put("HS", 329);
        map.put("HK", 466);
        map.put("HT", 148);
        map.put("PS", 408);
        map.put("PK", 577);
        map.put("PT", 260);
        map.put("SK", 287);
        map.put("ST", 226);
        map.put("KT", 312);
        map.put("PH", 103);
        map.put("SH", 329);
        map.put("KH", 466);
        map.put("TH", 148);
        map.put("SP", 408);
        map.put("KP", 577);
        map.put("TP", 260);
        map.put("KS", 287);
        map.put("TS", 226);
        map.put("TK", 312);

        return map;
    }

}
