import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, m, cnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++)
				map[i][j] = input.charAt(j);
		}

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (map[i][j] == '*')
					recur(i, j, 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '*' && !visit[i][j]) {
					cnt = 0;
					break;
				}
			}
		}

		bw.write(cnt == 0 ? "-1" : (cnt + "\n" + sb));
		bw.flush();
	}

	private static void recur(int y, int x, int depth) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i] * depth;
			int nx = x + dx[i] * depth;

			if (ny < 0 || nx < 0 || ny >= n || nx >= m)
				return;

			if (map[ny][nx] == '.')
				return;
		}

		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i] * depth;
			int nx = x + dx[i] * depth;

			visit[ny][nx] = true;
		}

		cnt++;
		sb.append((y + 1) + " " + (x + 1) + " " + depth + "\n");

		recur(y, x, depth + 1);
	}

}
