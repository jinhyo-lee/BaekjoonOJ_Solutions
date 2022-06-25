import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] floor;
	static int cnt = 1;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		floor = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				floor[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(r, c, d);
		bw.write(cnt + "\n");
		bw.flush();
	}

	private static void dfs(int y, int x, int dir) {
		floor[y][x] = 2;

		for (int i = 0; i < 4; i++) {
			dir -= 1;
			if (dir == -1)
				dir = 3;

			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
				if (floor[ny][nx] == 0) {
					cnt++;
					dfs(ny, nx, dir);
					return;
				}
			}
		}

		int d = (dir + 2) % 4;
		int by = y + dy[d];
		int bx = x + dx[d];
		
		if (floor[by][bx] != 1 && by >= 0 && bx >= 0 && by < n && bx < m)
			dfs(by, bx, dir);
	}

}
