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
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

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

				if (box[i][j] == 1) {
					q.add(new Loc(i, j));
				}
			}
		}

		bw.write(bfs() + "\n");
		bw.flush();
	}

	private static int bfs() {
		while (!q.isEmpty()) {
			Loc now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if (box[nextX][nextY] != 0) {
					continue;
				}

				box[nextX][nextY] = box[now.x][now.y] + 1;
				q.add(new Loc(nextX, nextY));
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
		int x;
		int y;

		public Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
