import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String n, res;
    static long num;
    static int limit;
    static boolean[] visit;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = br.readLine();
        num = Long.parseLong(n);
        int len = n.length();

        if (num >= 9876543210L)
            bw.write("9876543210");
        else if (num <= 10)
            bw.write(String.valueOf(num));
        else {
            visit = new boolean[10];
            if (len != 2) {
                limit = len - 2;
                visit[9] = true;
                recur(0, "9");
                visit[9] = false;
            }

            limit = len - 1;
            visit[n.charAt(0) - '0'] = true;
            recur(0, String.valueOf(n.charAt(0) - '0'));
            visit[n.charAt(0) - '0'] = false;

            if (len != 10) {
                limit = len;
                visit[1] = true;
                recur(0, "1");
            }

            bw.write(res);
        }

        bw.flush();
    }

    private static void recur(int depth, String perm) {
        if (depth == limit) {
            long gap = Math.abs(num - Long.parseLong(perm));
            if (min > gap) {
                min = gap;
                res = perm;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            recur(depth + 1, perm + i);
            visit[i] = false;
        }
    }

}
