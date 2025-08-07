import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        int[] A = new int[n], B = new int[n];
        for (int i = 0; i < n; i++) A[i] = read();
        for (int i = 0; i < n; i++) B[i] = read();

        Arrays.sort(A);
        Arrays.sort(B);

        List<Integer> list = new ArrayList<>(), a = new ArrayList<>(), b = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (A[i] == B[j]) {
                list.add(A[i++]);
                j++;
            } else if (A[i] < B[j]) a.add(A[i++]);
            else b.add(B[j++]);
        }

        while (i < n) a.add(A[i++]);
        while (j < n) b.add(B[j++]);

        sb.append(list.size()).append('\n');
        for (int k : list) sb.append(k).append(' ');
        for (int k : a) sb.append(k).append(' ');
        sb.append('\n');
        for (int k : list) sb.append(k).append(' ');
        for (int k : b) sb.append(k).append(' ');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
