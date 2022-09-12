import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (m > 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int button = Integer.parseInt(st.nextToken());
                broken[button] = true;
            }
        }

        int minCnt = Math.abs(n - 100);

        for (int i = 0; i < 1000000; i++) {
            String channel = String.valueOf(i);
            int press = channel.length();

            boolean isBroken = false;
            for (int j = 0; j < press; j++) {
                if (broken[channel.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int cnt = Math.abs(n - i) + press;
                minCnt = Math.min(minCnt, cnt);
            }
        }

        bw.write(minCnt + "\n");
        bw.flush();
    }

}
