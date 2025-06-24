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

        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) map.put(st.nextToken(), i);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = map.get(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) if (arr[i] < arr[j]) cnt++;

        bw.write(cnt + "/" + n * (n - 1) / 2);
        bw.flush();
    }

}
