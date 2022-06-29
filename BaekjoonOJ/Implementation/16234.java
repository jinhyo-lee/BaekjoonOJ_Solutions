import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, l, r;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static List<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		while (true) {
			boolean flag = false;
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						int sum = bfs(i, j);

						if (list.size() > 1) {
							union(sum);
							flag = true;
						}
					}
				}
			}
			if (!flag)
				break;

			cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	private static int bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();

		q.offer(new Node(y, x));
		list.add(new Node(y, x));
		visit[y][x] = true;

		int sum = map[y][x];
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = curr.y + dy[i];
				int nx = curr.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= n || nx >= n || visit[ny][nx])
					continue;

				int gap = Math.abs(map[curr.y][curr.x] - map[ny][nx]);
				if (gap >= l && gap <= r) {
					q.offer(new Node(ny, nx));
					list.add(new Node(ny, nx));
					sum += map[ny][nx];
					visit[ny][nx] = true;
				}
			}
		}

		return sum;
	}

	private static void union(int sum) {
		int avg = sum / list.size();
		for (Node n : list)
			map[n.y][n.x] = avg;
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
