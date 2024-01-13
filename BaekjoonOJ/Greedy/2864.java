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

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken(), b = st.nextToken();

        int min = Integer.parseInt(a.replace('6', '5')) + Integer.parseInt(b.replace('6', '5'));
        int max = Integer.parseInt(a.replace('5', '6')) + Integer.parseInt(b.replace('5', '6'));

        bw.write(sb.append(min).append(" ").append(max).toString());
        bw.flush();
    }

}
