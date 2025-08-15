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
            String s = br.readLine();
            int i = s.indexOf('-');
            sb.append(Math.abs(calc(s.substring(0, i)) - Integer.parseInt(s.substring(i + 1))) > 100 ? "not nice\n" : "nice\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(String s) {
        return (s.charAt(0) - 'A') * 676 + (s.charAt(1) - 'A') * 26 + (s.charAt(2) - 'A');
    }

}
