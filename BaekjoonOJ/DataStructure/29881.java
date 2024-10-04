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

        Map<String, String> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            map.put(arr[0], arr[1]);
        }

        while (n-- > 0) {
            String[] arr = br.readLine().split(" ");
            sb.append(map.get(arr[0])).append(" ").append(arr[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
