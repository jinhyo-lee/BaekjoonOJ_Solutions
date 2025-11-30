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
        int l = Integer.parseInt(s.substring(0, s.indexOf(' ')));
        String[] arr = new String[Integer.parseInt(s.substring(s.indexOf(' ') + 1))];
        for (int i = 0; i < arr.length; i++) arr[i] = br.readLine();

        Map<String, Integer> map = new HashMap<>();
        int k = Integer.parseInt(br.readLine());
        for (String S : arr)
            for (int i = l - k; i >= 0; i--) map.put(s = S.substring(i, i + k), map.getOrDefault(s, 0) + 1);

        int max = 0;
        for (int v : map.values()) max = Math.max(max, v);

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
