import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map = new boolean[101][101];
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			setCurve(y, x, d, g);
		}

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1])
					cnt++;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	private static void setCurve(int y, int x, int dir, int gen) {
		List<Integer> list = new ArrayList<>();
		list.add(dir);

		for (int i = 0; i < gen; i++) {
			for (int j = list.size() - 1; j >= 0; j--)
				list.add((list.get(j) + 1) % 4);
		}

		map[y][x] = true;
		for (Integer i : list) {
			y += dy[i];
			x += dx[i];
			map[y][x] = true;
		}
	}

}
