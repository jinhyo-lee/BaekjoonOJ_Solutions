import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int l;
	static int[][] visit;
	static int[] dy = { 1, 1, -1, -1, 2, 2, -2, -2 };
	static int[] dx = { 2, -2, 2, -2, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			l = Integer.parseInt(br.readLine());
			visit = new int[l][l];

			st = new StringTokenizer(br.readLine());
			Node root = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Node dest = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			bfs(root, dest);
			bw.write(visit[dest.y][dest.x] - 1 + "\n");
		}

		bw.flush();
	}

	private static void bfs(Node root, Node dest) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		visit[root.y][root.x] = 1;

		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.y == dest.y && now.x == dest.x) 
				return;

			for (int i = 0; i < 8; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= l || nx >= l)
					continue;
				if (visit[ny][nx] != 0)
					continue;

				q.offer(new Node(ny, nx));
				visit[ny][nx] = visit[now.y][now.x] + 1;
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
