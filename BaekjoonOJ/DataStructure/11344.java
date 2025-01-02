import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<String> q = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            int n = Integer.parseInt(br.readLine()), cnt = 0;
            while (n-- > 0) {
                if (!q.isEmpty() && cnt > 0) {
                    q.poll();
                    cnt--;
                }

                String s = br.readLine();
                if (s.endsWith("15")) cnt++;
                else if (cnt > 0) cnt--;
                else {
                    q.offer(s.substring(0, s.indexOf(" ")));
                    if (list.size() < q.size()) list = new ArrayList<>(q);
                }
            }

            bw.write(list.isEmpty() ? "Line B stayed empty.\n" : print(list));
            q.clear();
            list.clear();
        }

        bw.flush();
    }

    private static String print(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s).append(" ");

        return sb.append("\n").toString();
    }

}
