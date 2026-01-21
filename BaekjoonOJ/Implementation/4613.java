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
            int sum = 0, l = s.length();
            for (int i = 0; i < l; ) sum += Math.max(0, s.charAt(i++) - '@') * i;
            sb.append(sum).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
