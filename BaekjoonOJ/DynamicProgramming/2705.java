import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(2);

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = dp.size(); i < n; i++)
                dp.add(dp.get((i - 1) / 2) + dp.get(i - 2));

            sb.append(dp.get(n - 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
