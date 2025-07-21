import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] mat = new int[read()][];
        int m = read();
        for (int i = 0; i < mat.length; i++) {
            int[] arr = new int[read()];
            for (int j = 0; j < arr.length; j++) arr[j] = read();
            mat[i] = arr;
        }

        int[] cnt = new int[m + 1];
        for (int[] arr : mat) for (int i : arr) cnt[i]++;

        bw.write(isPossible(mat, cnt) ? "1" : "0");
        bw.flush();
    }

    private static boolean isPossible(int[][] mat, int[] cnt) {
        for (int[] arr : mat) {
            boolean flag = true;
            for (int i : arr) if (--cnt[i] == 0) flag = false;
            if (flag) return true;
            for (int i : arr) cnt[i]++;
        }

        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
