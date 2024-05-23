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

        StringTokenizer st = new StringTokenizer(br.readLine(), "+=");

        bw.write(search(new int[][]{count(st.nextToken()), count(st.nextToken()), count(st.nextToken())}));
        bw.flush();
    }

    private static String search(int[][] mat) {
        for (int i = 1; i < 11; i++)
            for (int j = 1; j < 11; j++)
                for (int k = 1; k < 11; k++) if (compare(mat, i, j, k)) return i + " " + j + " " + k;

        return "";
    }

    private static int[] count(String s) {
        int[] arr = new int[3];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) == 'C' ? 0 : s.charAt(i) == 'H' ? 1 : 2] += i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)) ? s.charAt(++i) - '0' : 1;

        return arr;
    }

    private static boolean compare(int[][] mat, int i, int j, int k) {
        return mat[0][0] * i + mat[1][0] * j == mat[2][0] * k && mat[0][1] * i + mat[1][1] * j == mat[2][1] * k && mat[0][2] * i + mat[1][2] * j == mat[2][2] * k;
    }

}
