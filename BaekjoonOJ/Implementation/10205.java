import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        for (int t = 1; t <= k; t++) {
            int h = Integer.parseInt(br.readLine());
            for (char c : br.readLine().toCharArray()) h += c == 'c' ? 1 : -1;
            sb.append("Data Set ").append(t).append(":\n").append(h).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
