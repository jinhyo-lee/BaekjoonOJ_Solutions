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
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

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

	private static void bfs(int x, int y) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));

		while (!q.isEmpty()) {
			Loc now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if (visited[nextX][nextY] || maze[nextX][nextY] == 0) {
					continue;
				}

				q.add(new Loc(nextX, nextY));
				maze[nextX][nextY] = maze[now.x][now.y] + 1;
				visited[nextX][nextY] = true;
			}
		}	
	}

	private static class Loc {
		int x;
		int y;

		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
