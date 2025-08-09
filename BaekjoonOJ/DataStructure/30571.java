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

        Map<Double, String> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine()), i = 0;
        while (n-- > 0) {
            double d = parseDouble(br.readLine());
            if (!map.containsKey(d)) map.put(d, generate(i++));
            sb.append(map.get(d)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static double parseDouble(String s) {
        return Double.parseDouble(s.substring(0, s.length() - 1));
    }

    private static String generate(int i) {
        StringBuilder sb = new StringBuilder();
        do sb.append((char) (i % 26 + 'a')); while ((i /= 10) > 0);

        return sb.toString();
    }

}
