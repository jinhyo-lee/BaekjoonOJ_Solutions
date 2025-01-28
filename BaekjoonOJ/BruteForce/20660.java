import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static boolean[] arr = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) arr[Integer.parseInt(st.nextToken())] = true;

        int m = Integer.parseInt(br.readLine()), cnt = 0;
        while (m-- > 0) if (!contains(br.readLine())) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean contains(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int k = Integer.parseInt(st.nextToken());
        while (k-- > 0) if (arr[Integer.parseInt(st.nextToken())]) return true;

        return false;
    }

}
