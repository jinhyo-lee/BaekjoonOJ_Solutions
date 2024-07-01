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

        String x = br.readLine();
        int cnt = 0;
        if (x.length() > 1) do cnt++; while ((x = convert(x)).length() > 1);

        sb.append(cnt).append("\n").append(Integer.parseInt(x) % 3 == 0 ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
    }

    private static String convert(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';

        return Integer.toString(sum);
    }

}
