import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), sum = 0;
        int[] arr = new int[n];
        while (n-- > 0) sum += arr[n] = read();

        Set<Integer> set = new TreeSet<>();
        for (int i : arr) set.add(sum - i);

        sb.append(set.size()).append("\n");
        for (int i : set) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
