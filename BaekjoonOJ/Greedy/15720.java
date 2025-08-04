import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    static int min, sum, off;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {read(), read(), read()};
        min = Math.min(arr[0], Math.min(arr[1], arr[2]));
        for (int i : arr) calc(i);

        bw.write(sum + "\n" + (sum - off));
        bw.flush();
    }

    private static void calc(int n) throws IOException {
        for (int i = 0, j; i < n; i++, sum += j) pq.add(j = read());
        for (int i = 0; i < min; i++) off += pq.remove() / 10;
        pq.clear();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
