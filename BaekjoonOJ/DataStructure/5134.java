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

        Map<String, Integer> a = new HashMap<>();
        Map<String, Double> b = new HashMap<>();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            String s = br.readLine();
            int i = s.indexOf(' ');
            int n = Integer.parseInt(s.substring(0, i)), m = Integer.parseInt(s.substring(i + 1));
            while (n-- > 0) register(br.readLine(), a, b);

            double sum = 0;
            while (m-- > 0) {
                s = br.readLine();
                i = s.indexOf(' ');
                String key = s.substring(i + 1).toLowerCase();
                if (b.containsKey(key)) sum += b.get(key) * Math.min(Integer.parseInt(s.substring(0, i)), a.get(key));
            }
            sb.append("Data Set ").append(tc).append(String.format(":\n$%.2f\n\n", sum));
            a.clear();
            b.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void register(String s, Map<String, Integer> a, Map<String, Double> b) {
        int i = s.indexOf(' '), j = s.indexOf(' ', i + 1), k = s.indexOf(' ', j + 1);
        String key = s.substring(k + 1).toLowerCase();
        a.put(key, Integer.parseInt(s.substring(0, i)));
        b.put(key, Double.parseDouble(s.substring(i + 2, j)) - Double.parseDouble(s.substring(j + 2, k)));
    }

}
