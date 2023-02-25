import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static String perm, res;
    static int idx, cnt;
    static char[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            perm = st.nextToken();
            idx = Integer.parseInt(st.nextToken());

            cnt = 0;
            arr = new char[perm.length()];
            visit = new boolean[perm.length()];

            recur(0);

            res = cnt < idx ? "No permutation" : res;
            bw.write(perm + " " + idx + " = " + res + "\n");
        }

        bw.flush();
    }

    private static void recur(int depth) {
        if (depth == perm.length()) {
            cnt++;
            if (cnt == idx)
                res = String.valueOf(arr);

            return;
        }

        for (int i = 0; i < perm.length(); i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            arr[depth] = perm.charAt(i);
            recur(depth + 1);
            visit[i] = false;
        }
    }

}
