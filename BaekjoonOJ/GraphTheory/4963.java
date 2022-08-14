import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int w, h;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dx = { 0, 0, -1, 1, -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 0)
						continue;

					bfs(i, j);
					cnt++;
				}
			}

			bw.write(cnt + "\n");
		}

		bw.flush();
	}

	private static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		map[y][x] = 0;

		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 8; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= h || nx >= w)
					continue;
				if (map[ny][nx] == 0)
					continue;

				q.offer(new Node(ny, nx));
				map[ny][nx] = 0;
			}
		}
	}

	private static class Node {
		int y;
		int x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
