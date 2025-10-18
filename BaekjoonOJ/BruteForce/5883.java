import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();
        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) set.add(arr[i] = read());

        int max = 0;
        for (int n : set) {
            int cnt = 0, i = arr[0];
            for (int j : arr) {
                if (n == j) continue;
                if (i == j) max = Math.max(max, ++cnt);
                else {
                    cnt = 1;
                    i = j;
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
