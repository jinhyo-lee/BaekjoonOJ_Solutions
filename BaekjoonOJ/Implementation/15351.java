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

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int sum = 0;
            for (char c : br.readLine().toCharArray()) if (c != ' ') sum += c - 64;
            sb.append(sum == 100 ? "PERFECT LIFE" : sum).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
