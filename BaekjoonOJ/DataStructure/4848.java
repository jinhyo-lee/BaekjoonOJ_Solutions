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

        String[] arr = new String[16];
        arr[0] = "{}";

        Map<String, Integer> map = new HashMap<>();
        map.put("{}", 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 16; i++, sb.setLength(0)) {
            sb.append("{");
            for (int j = 0; j < i; j++)
                sb.append(arr[j]).append(",");

            sb.setCharAt(sb.length() - 1, '}');

            arr[i] = sb.toString();
            map.put(arr[i], i);
        }

        int n = Integer.parseInt(br.readLine());
        sb.setLength(0);

        while (n-- > 0) sb.append(arr[map.get(br.readLine()) + map.get(br.readLine())]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
