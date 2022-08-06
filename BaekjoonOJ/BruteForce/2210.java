import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String[][] map = new String[5][5];
    static List<String> list = new ArrayList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++)
            map[i] = br.readLine().split(" ");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                recur(map[i][j], i, j);
        }

        bw.write(list.size() + "\n");
        bw.flush();
    }

    private static void recur(String s, int y, int x) {
        if (s.length() == 6) {
            if (!list.contains(s))
                list.add(s);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5)
                continue;

            recur(s + map[ny][nx], ny, nx);
        }
    }

}
