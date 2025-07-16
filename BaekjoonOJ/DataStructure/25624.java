import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("YES\n");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[][] mat = new int[n][];
        for (int i = 0; i < n; i++) mat[i] = new int[26];
        for (int i = 0, j = 0; i < m; i++, j = 0) for (char c : br.readLine().toCharArray()) mat[j++][c - 'A']++;

        Set<Character> set = new HashSet<>();
        int sum = 1;
        label:
        for (int[] arr : mat) {
            int cnt = 0, prv = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                cnt++;

                char c = (char) (i + 'A');
                if (!set.add(c) || (prv != 0 && prv != arr[i])) {
                    sb = new StringBuilder("NO");
                    break label;
                }
                sb.append(c);
                prv = arr[i];
            }
            sb.append('\n');
            sum *= cnt;
        }

        bw.write(sum == m ? sb.toString() : "NO");
        bw.flush();
    }

}
