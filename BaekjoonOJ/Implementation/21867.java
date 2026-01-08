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
        String s = br.readLine();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) != 'J' && s.charAt(i) != 'A' && s.charAt(i) != 'V') sb.append(s.charAt(i));

        bw.write(sb.length() > 0 ? sb.toString() : "nojava");
        bw.flush();
    }

}
