import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Shark now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					now = new Shark(i, j, 0);
					map[i][j] = 0;
				}
			}
		}

		bw.write(bfs(2, 0, 0) + "\n");
		bw.flush();
	}

	private static int bfs(int size, int eat, int cnt) {
		while (true) {
			PriorityQueue<Shark> q = new PriorityQueue<>(
					(o1, o2) -> o1.dist != o2.dist ? Integer.compare(o1.dist, o2.dist)
							: (o1.y != o2.y ? Integer.compare(o1.y, o2.y) : Integer.compare(o1.x, o2.x)));
			q.offer(new Shark(now.y, now.x, 0));

			boolean[][] visit = new boolean[n][n];
			visit[now.y][now.x] = true;

			boolean flag = false;
			while (!q.isEmpty()) {
				now = q.poll();

				if (map[now.y][now.x] != 0 && map[now.y][now.x] < size) {
					map[now.y][now.x] = 0;
					eat++;
					cnt += now.dist;
					flag = true;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int ny = now.y + dy[i];
					int nx = now.x + dx[i];

					if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] > size || visit[ny][nx])
						continue;

					q.offer(new Shark(ny, nx, now.dist + 1));
					visit[ny][nx] = true;
				}
			}

			if (!flag)
				break;
			if (size == eat) {
				size++;
				eat = 0;
			}
		}

		return cnt;
	}

	private static class Shark {
		int y;
		int x;
		int dist;

		Shark(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

}
