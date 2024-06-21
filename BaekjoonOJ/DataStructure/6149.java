import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read(), k = read(), p = read();

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) q.offer(i);

        Player[] arr = new Player[n];
        for (int i = 0; i < n; i++) arr[i] = new Player();

        int idx = 0;
        while (!q.isEmpty()) {
            arr[idx++ % n].list.add(q.poll());
            if (!q.isEmpty()) for (int j = 0; j < p; j++) q.offer(q.poll());
        }

        Collections.sort(arr[n - 1].list);
        for (int i : arr[n - 1].list) sb.append(i).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Player {
        List<Integer> list = new ArrayList<>();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
