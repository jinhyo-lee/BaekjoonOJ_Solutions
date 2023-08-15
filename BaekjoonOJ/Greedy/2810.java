import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 1;
        for (int i = 0; i < s.length(); i++, cnt++)
            if (s.charAt(i) == 'L') i++;

        bw.write(String.valueOf(Math.min(cnt, n)));
        bw.flush();
    }

}
