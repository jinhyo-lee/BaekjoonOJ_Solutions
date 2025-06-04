import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static Target[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        arr = new Target[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean b = st.nextToken().charAt(0) == 'r';
            arr[i] = new Target(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), b ? Integer.parseInt(st.nextToken()) : 1001);
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), cnt = 0;
            for (Target t : arr) if (isHit(x, y, t)) cnt++;
            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isHit(int x, int y, Target t) {
        if (t.y2 < 1001) return x >= t.x1 && x <= t.x2 && y >= t.y1 && y <= t.y2;
        else return (x - t.x1) * (x - t.x1) + (y - t.y1) * (y - t.y1) <= t.x2 * t.x2;
    }

    private static class Target {
        int x1, y1, x2, y2;

        Target(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

}
