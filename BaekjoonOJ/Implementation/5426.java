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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            int l = (int) Math.sqrt(s.length());
            for (int i = l - 1; i >= 0; i--) for (int j = 0; j < l; j++) sb.append(s.charAt(i + j * l));
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
