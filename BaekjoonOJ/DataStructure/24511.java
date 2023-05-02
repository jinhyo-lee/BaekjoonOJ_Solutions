import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[] info = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");

        Queue<String> q = new LinkedList<>();

        while (n-- > 0) {
            if (info[n].equals("0"))
                q.offer(input[n]);
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            q.offer(st.nextToken());
            sb.append(q.poll()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
