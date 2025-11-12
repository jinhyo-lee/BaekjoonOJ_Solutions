import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        for (int tc = 1; tc <= t; tc++) {
            int[][] mat = new int[read()][3];
            for (int i = 0; i < mat.length; i++) mat[i] = new int[]{read(), read(), read()};

            List<Data> list = new ArrayList<>();
            int max = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = i + 1; j < mat.length; j++) {
                    int k = calc(mat[i], mat[j]);
                    if (max < k) {
                        max = k;
                        list.clear();
                        list.add(new Data(i, j, k));
                    } else if (max == k) list.add(new Data(i, j, k));
                }
            }

            sb.append("Data Set ").append(tc).append(":\n");
            for (Data d : list) sb.append(d.x + 1).append(' ').append(d.y + 1).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]) + (a[2] - b[2]) * (a[2] - b[2]);
    }

    private static class Data {
        int x, y, z;

        Data(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
