import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new boolean[26][26];
        while (n-- > 0) {
            String input = br.readLine();
            int src = input.charAt(0) - 'a';
            int tgt = input.charAt(input.length() - 1) - 'a';
            arr[src][tgt] = true;
        }

        floydWarshall();

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String input = br.readLine();
            int src = input.charAt(0) - 'a';
            int tgt = input.charAt(input.length() - 1) - 'a';
            sb.append(arr[src][tgt] ? "T" : "F").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void floydWarshall() {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (i == k)
                    arr[i][k] = true;
                for (int j = 0; j < 26; j++) {
                    if (arr[i][k] && arr[k][j])
                        arr[i][j] = true;
                }
            }
        }
    }

}
