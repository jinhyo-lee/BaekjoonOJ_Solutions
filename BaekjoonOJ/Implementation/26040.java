import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] arr = new boolean[26];
        while (st.hasMoreTokens()) arr[st.nextToken().charAt(0) - 'A'] = true;

        for (char c : s.toCharArray()) sb.append(c < 'a' && arr[c - 'A'] ? (char) (c + 32) : c);

        bw.write(sb.toString());
        bw.flush();
    }

}
