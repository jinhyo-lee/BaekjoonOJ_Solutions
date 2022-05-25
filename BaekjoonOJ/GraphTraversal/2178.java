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
	static int[][] maze;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[n][m];
		visited[0][0] = true;

		bfs(0, 0);

		bw.write(maze[n - 1][m - 1] + "\n");
		bw.flush();
	}

	private static void bfs(int y, int x) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(y, x));

		while (!q.isEmpty()) {
			Loc now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + dy[i];
				int nextX = now.x + dx[i];

				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) {
					continue;
				}
				if (visited[nextY][nextX] || maze[nextY][nextX] == 0) {
					continue;
				}

				q.add(new Loc(nextY, nextX));
				maze[nextY][nextX] = maze[now.y][now.x] + 1;
				visited[nextY][nextX] = true;
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
