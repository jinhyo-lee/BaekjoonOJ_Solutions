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

        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(concat(st.nextToken(), st.nextToken()) + concat(st.nextToken(), st.nextToken())));
        bw.flush();
    }

    private static long concat(String a, String b) {
        return (long) (Integer.parseInt(a) * Math.pow(10, b.length()) + Integer.parseInt(b));
    }

}
