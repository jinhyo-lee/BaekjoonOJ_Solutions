import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] lab;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int maxCnt = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lab = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				lab[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(0);

		bw.write(maxCnt + "\n");
		bw.flush();
	}

	private static void dfs(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (lab[i][j] == 0) {
					lab[i][j] = 1;
					dfs(wall + 1);
					lab[i][j] = 0;
				}
			}
		}
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (lab[i][j] == 2)
					q.offer(new Node(i, j));
			}
		}

		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++)
			copy[i] = lab[i].clone();

		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
					if (copy[ny][nx] == 0) {
						q.offer(new Node(ny, nx));
						copy[ny][nx] = 2;
					}
				}
			}
		}

		safe(copy);
	}

	private static void safe(int[][] copy) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 0)
					cnt++;
			}
		}

		if (maxCnt < cnt)
			maxCnt = cnt;
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
