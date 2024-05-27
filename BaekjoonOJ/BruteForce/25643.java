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
        int n = Integer.parseInt(st.nextToken());

        String a = br.readLine(), b;
        while (n-- > 1 && isStackable(a, b = br.readLine())) a = b;

        bw.write(n == 0 ? "1" : "0");
        bw.flush();
    }

    private static boolean isStackable(String a, String b) {
        for (int i = 1; i <= a.length(); i++)
            if (a.startsWith(b.substring(a.length() - i)) || b.startsWith(a.substring(a.length() - i))) return true;

        return false;
    }

}
