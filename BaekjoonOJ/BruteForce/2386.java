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

        String s;
        while ((s = br.readLine()).charAt(0) != '#') {
            char a = s.charAt(0);
            int cnt = 0;
            for (char c : s.substring(2).toLowerCase().toCharArray()) if (c == a) cnt++;
            sb.append(a).append(' ').append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
