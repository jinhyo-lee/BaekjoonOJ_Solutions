import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int n, k;
    static boolean[] visit;
    static int[] arr;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        visit = new boolean[n];
        arr = new int[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        recur(0, "");

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    private static void recur(int depth, String str) {
        if (depth == k) {
            set.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            recur(depth + 1, str + arr[i]);
            visit[i] = false;
        }
    }

}
