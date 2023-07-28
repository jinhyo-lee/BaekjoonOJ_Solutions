import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            map.put(key, map.getOrDefault(key, 0) + Integer.parseInt(st.nextToken()));
        }

        bw.write(isDelicious() ? "Delicious!" : "Not Delicious...");
        bw.flush();
    }

    private static boolean isDelicious() {
        for (String key : map.keySet())
            if (containsValue(key, (int) (map.get(key) * 1.618))) return true;

        return false;
    }

    private static boolean containsValue(String exclude, int value) {
        for (String key : map.keySet())
            if (!key.equals(exclude) && map.get(key) == value) return true;

        return false;
    }

}
