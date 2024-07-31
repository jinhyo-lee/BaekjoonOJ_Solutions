import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> col = new ArrayList<>(Arrays.asList(0, read())), row = new ArrayList<>(Arrays.asList(0, read()));
        int n = read();
        while (n-- > 0) {
            if (read() == 0) row.add(read());
            else col.add(read());
        }

        Collections.sort(row);
        Collections.sort(col);

        int y = 0;
        for (int i = 1; i < row.size(); i++) y = Math.max(y, row.get(i) - row.get(i - 1));

        int x = 0;
        for (int i = 1; i < col.size(); i++) x = Math.max(x, col.get(i) - col.get(i - 1));

        bw.write(String.valueOf(y * x));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
