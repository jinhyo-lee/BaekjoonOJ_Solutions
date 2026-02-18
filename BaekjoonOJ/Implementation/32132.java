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

        int n = Integer.parseInt(br.readLine()), flag = 0;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'P') flag = 1;
            else if (c == 'S' && flag == 1) flag = 2;
            else if ((c == '4' || c == '5') && flag == 2) continue;
            else flag = 0;
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
