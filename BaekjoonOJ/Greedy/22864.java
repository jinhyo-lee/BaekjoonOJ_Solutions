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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int fatigue = 0, work = 0;

        if (a <= m) {
            for (int i = 0; i < 24; i++) {
                if (fatigue + a <= m) {
                    fatigue += a;
                    work += b;
                } else
                    fatigue = Math.max(fatigue - c, 0);
            }
        }

        bw.write(String.valueOf(work));
        bw.flush();
    }

}
