import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int m;
	static int n;
	static int[][] box;
	static Queue<Loc> q;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);

		box = new int[n][m];
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(s[j]);

				if (box[i][j] == 1)
					q.offer(new Loc(i, j));
			}
		}

		bw.write(bfs() + "\n");
		bw.flush();
	}

	private static int bfs() {
		while (!q.isEmpty()) {
			Loc now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + dy[i];
				int nextX = now.x + dx[i];

				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
					continue;
				if (box[nextY][nextX] != 0)
					continue;

				box[nextY][nextX] = box[now.y][now.x] + 1;
				q.offer(new Loc(nextY, nextX));
			}
		}

		int day = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					day = -1;
					return day;
				}

				day = Math.max(day, box[i][j]);
			}
		}

		return day - 1;
	}

	private static class Loc {
		int y;
		int x;

		public Loc(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
