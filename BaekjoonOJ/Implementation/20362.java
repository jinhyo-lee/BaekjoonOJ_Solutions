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

        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(' ')));
        s = s.substring(s.indexOf(' ') + 1);

        Map<String, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String a = br.readLine(), b = a.substring(a.lastIndexOf(' ') + 1);
            if (s.equals(a.substring(0, a.indexOf(' ')))) {
                bw.write(String.valueOf(map.getOrDefault(b, 0)));
                break;
            } else map.put(b, map.getOrDefault(b, 0) + 1);
        }

        bw.flush();
    }

}
