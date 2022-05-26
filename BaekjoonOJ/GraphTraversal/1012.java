import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int m;
	static int n;
	static int[][] field;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int c = 0; c < t; c++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			field = new int[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (field[i][j] == 1) {
						field[i][j] = 0;
						bfs(i, j);
						cnt++;
					}
				}
			}

			bw.write(cnt + "\n");
		}

		bw.flush();
	}

	private static void bfs(int y, int x) {
		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(y, x));

		while (!q.isEmpty()) {
			Loc now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + dy[i];
				int nextX = now.x + dx[i];

				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
					continue;
				if (field[nextY][nextX] == 0)
					continue;

				q.offer(new Loc(nextY, nextX));
				field[nextY][nextX] = 0;
			}
		}

	}

	private static class Loc {
		int y;
		int x;

		Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
