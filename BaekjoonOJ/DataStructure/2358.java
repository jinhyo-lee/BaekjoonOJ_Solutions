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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> y = new HashMap<>(), x = new HashMap<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            if (y.containsKey(input))
                y.put(input, y.get(input) + 1);
            else
                y.put(input, 0);

            input = Integer.parseInt(st.nextToken());
            if (x.containsKey(input))
                x.put(input, x.get(input) + 1);
            else
                x.put(input, 0);
        }

        int cnt = 0;
        for (int key : y.keySet())
            if (y.get(key) > 0)
                cnt++;

        for (int key : x.keySet())
            if (x.get(key) > 0)
                cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
