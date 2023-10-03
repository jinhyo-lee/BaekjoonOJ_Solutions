import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        while (n-- > 0) arr[n] = br.readLine();

        bw.write(decoding(sb, arr));
        bw.flush();
    }

    private static String decoding(StringBuilder sb, String[] arr) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < sb.length(); j++) sb.setCharAt(j, (char) ('a' + (sb.charAt(j) - 'a' + 1) % 26));
            for (String s : arr) if (sb.indexOf(s) != -1) return sb.toString();
        }

        return sb.toString();
    }

}
