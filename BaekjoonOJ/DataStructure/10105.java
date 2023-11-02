import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(isGood(Integer.parseInt(br.readLine()), new StringTokenizer(br.readLine()), new StringTokenizer(br.readLine())) ? "good" : "bad");
        bw.flush();
    }

    private static boolean isGood(int n, StringTokenizer a, StringTokenizer b) {
        Map<String, String> map = new HashMap<>();
        while (n-- > 0) {
            String key = a.nextToken(), value = b.nextToken();

            if (key.equals(value)) return false;
            if (map.containsKey(value) && !map.get(value).equals(key)) return false;
            map.put(key, value);
        }

        return true;
    }

}
