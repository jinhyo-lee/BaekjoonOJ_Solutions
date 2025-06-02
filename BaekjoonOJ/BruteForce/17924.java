import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] mat = new int[read()][2];
        for (int i = 0; i < mat.length; i++) {
            mat[i][0] = read();
            mat[i][1] = read();
        }

        bw.write(isImpossible(mat));
        bw.flush();
    }

    private static String isImpossible(int[][] mat) {
        label:
        for (int i = 0; i < 1001; i++) {
            for (int[] arr : mat) if (i < arr[0] || i > arr[1]) continue label;
            return "gunilla has a point";
        }

        return "edward is right";
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
