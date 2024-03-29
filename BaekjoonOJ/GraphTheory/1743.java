import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[][] floor;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		floor = new int[n][m];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			floor[y][x] = 1;
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (floor[i][j] == 1) {
					floor[i][j] = 0;
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		bw.write(max + "\n");
		bw.flush();
	}

	private static int bfs(int y, int x) {
		Queue<Loc> q = new LinkedList<>();
		q.offer(new Loc(y, x));

		int cnt = 1;
		while (!q.isEmpty()) {
			Loc now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + dy[i];
				int nextX = now.x + dx[i];

				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
					continue;
				if (floor[nextY][nextX] == 0)
					continue;

				q.offer(new Loc(nextY, nextX));
				floor[nextY][nextX] = 0;
				cnt++;
			}
		}

		return cnt;
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
