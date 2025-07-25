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
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        String o;
        if (!(o = calc(a, b, c)).isEmpty()) bw.write(a + o + b + "=" + c);
        else bw.write(a + "=" + b + calc(b, c, a) + c);

        bw.flush();
    }

    private static String calc(int o1, int o2, int r) {
        if (o1 + o2 == r) return "+";
        else if (o1 - o2 == r) return "-";
        else if (o1 * o2 == r) return "*";
        else if (o1 / o2 == r) return "/";

        return "";
    }

}
