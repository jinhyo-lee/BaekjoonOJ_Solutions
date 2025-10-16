import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] arr = br.readLine().split(" ");
            for (int i = 2; i < arr.length; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        String s = "";
        int max = 0;
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= max) {
                s = entry.getKey();
                if (max == entry.getValue()) s = "-1";
                else max = entry.getValue();
            }
        }

        bw.write(s);
        bw.flush();
    }

}
