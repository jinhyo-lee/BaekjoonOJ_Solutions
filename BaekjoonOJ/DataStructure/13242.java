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

        Map<String, Integer> map = new HashMap<>();
        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(" ")));
        while (n-- > 0) map.put(s = br.readLine(), map.getOrDefault(s, 0) + 1);

        int max = 0;
        for (int i : map.values()) max = Math.max(max, i);

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
