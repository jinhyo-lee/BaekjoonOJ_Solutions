import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = n * 2;
        boolean[] arr = new boolean[m + 1];
        for (int i = 0; i < n; i++) arr[read()] = true;

        List<Integer> E = new ArrayList<>(), B = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            if (arr[i]) E.add(i);
            else B.add(i);
        }

        int e = 0, b = 0, cnt = 0;
        do {
            if (E.get(e++) < B.get(b++)) cnt++;
            else e--;
        } while (e < n && b < n);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
