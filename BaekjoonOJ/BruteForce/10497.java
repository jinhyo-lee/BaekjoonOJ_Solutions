import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static Diagram[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        arr = new Diagram[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean b = st.nextToken().charAt(0) == 'r';
            arr[i] = new Diagram(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), b ? Integer.parseInt(st.nextToken()) : 1001);
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), cnt = 0;
            for (Diagram d : arr) if (isHit(x, y, d)) cnt++;
            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isHit(int x, int y, Diagram d) {
        if (d.y2 < 1001) return x >= d.x1 && x <= d.x2 && y >= d.y1 && y <= d.y2;
        else return (d.x1 - x) * (d.x1 - x) + (d.y1 - y) * (d.y1 - y) <= d.x2 * d.x2;
    }

    private static class Diagram {
        int x1, y1, x2, y2;

        Diagram(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

}
