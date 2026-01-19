import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] digits = {{'*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}, {'*', ' ', '*', ' ', ' ', '*', ' ', ' ', '*', ' ', ' ', '*', '*', ' ', '*', '*', ' ', ' ', '*', ' ', ' ', ' ', ' ', '*', '*', ' ', '*', '*', ' ', '*'}, {'*', ' ', '*', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', '*', '*'}, {'*', ' ', '*', ' ', ' ', '*', '*', ' ', ' ', ' ', ' ', '*', ' ', ' ', '*', ' ', ' ', '*', '*', ' ', '*', ' ', ' ', '*', '*', ' ', '*', ' ', ' ', '*'}, {'*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*', '*', '*', '*'}};
    static char[][] mat = new char[5][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) mat[i] = br.readLine().toCharArray();

        int f = pow((mat[0].length + 1) / 4), sum = 0;
        for (int i = 0; i < mat[0].length; i += 4, f /= 10) {
            int n = search(i);
            if (n == -1) {
                sum = -1;
                break;
            }
            sum += n * f;
        }

        bw.write(sum % 6 != 0 ? "BOOM!!" : "BEER!!");
        bw.flush();
    }

    private static int search(int k) {
        for (int d = 0; d < 30; d += 3) if (compare(d, k)) return d / 3;

        return -1;
    }

    private static boolean compare(int d, int k) {
        try {
            for (int i = 0; i < 5; i++, d -= 3)
                for (int j = k; j < k + 3; j++) if (mat[i][j] != digits[i][d++]) return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    private static int pow(int i) {
        int f = 1;
        while (--i > 0) f *= 10;

        return f;
    }

}
