import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<String> q = new ArrayDeque<>();
        List<String> a = new ArrayList<>(), b = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = st.countTokens() - 1, n = Integer.parseInt(br.readLine());
        while (n-- > 0) q.offer(br.readLine());

        while (!q.isEmpty()) {
            for (int i = 0; i < t; i++) q.offer(q.poll());
            if (a.size() <= b.size()) a.add(q.poll());
            else b.add(q.poll());
        }

        sb.append(a.size()).append('\n');
        for (String s : a) sb.append(s).append('\n');
        sb.append(b.size()).append('\n');
        for (String s : b) sb.append(s).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

}
