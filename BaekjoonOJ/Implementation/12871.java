import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine(), t = br.readLine();

        bw.write(repeat(s, t.length()).equals(repeat(t, s.length())) ? '1' : '0');
        bw.flush();
    }

    private static String repeat(String s, int i) {
        StringBuilder sb = new StringBuilder();
        while (i-- > 0) sb.append(s);

        return sb.toString();
    }

}
