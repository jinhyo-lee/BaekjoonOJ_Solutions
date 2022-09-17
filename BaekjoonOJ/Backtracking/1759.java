import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int l, c;
    static char[] code;
    static boolean[] visit;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        code = new char[c];
        visit = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++)
            code[i] = st.nextToken().charAt(0);

        Arrays.sort(code);

        recur(0, 0);

        bw.write(result.toString());
        bw.flush();
    }

    private static void recur(int idx, int depth) {
        if (depth == l) {
            int vow = 0;
            int cons = 0;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c; i++) {
                if (visit[i]) {
                    sb.append(code[i]);

                    if (isVowel(code[i]))
                        vow++;
                    else
                        cons++;
                }
            }

            if (vow >= 1 && cons >= 2)
                result.append(sb + "\n");
        }

        for (int i = idx; i < c; i++) {
            visit[i] = true;
            recur(i + 1, depth + 1);
            visit[i] = false;
        }
    }

    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        else
            return false;
    }

}
