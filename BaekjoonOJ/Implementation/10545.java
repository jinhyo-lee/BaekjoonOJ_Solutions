import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[][] mat = {{2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}, {4, 1}, {4, 2}, {4, 3}, {5, 1}, {5, 2}, {5, 3}, {6, 1}, {6, 2}, {6, 3}, {7, 1}, {7, 2}, {7, 3}, {7, 4}, {8, 1}, {8, 2}, {8, 3}, {9, 1}, {9, 2}, {9, 3}, {9, 4}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 10; i++) arr[Integer.parseInt(st.nextToken())] = i;

        int prev = -1;
        for (char c : br.readLine().toCharArray()) {
            int k = mat[c - 'a'][0], v = arr[k];
            if (prev == k) sb.append('#');

            for (int i = mat[c - 'a'][1]; i > 0; i--) sb.append(v);
            prev = k;
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
