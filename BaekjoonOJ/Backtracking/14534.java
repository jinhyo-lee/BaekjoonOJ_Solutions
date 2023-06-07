import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String input;
    static int len;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            input = br.readLine();
            len = input.length();

            result.append("Case # ").append(i).append(":\n");
            generatePerm("", new boolean[len], 0);
        }

        bw.write(result.toString());
        bw.flush();
    }

    private static void generatePerm(String perm, boolean[] visit, int depth) {
        if (depth == len) {
            result.append(perm).append("\n");
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            generatePerm(perm + input.charAt(i), visit, depth + 1);
            visit[i] = false;
        }
    }

}
