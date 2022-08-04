import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int h, w, n, maxSize;
	static boolean[][] map;
	static boolean[] visit;
	static List<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(br.readLine());

		map = new boolean[h][w];
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.add(new Node(h, w, i));
			list.add(new Node(w, h, i));
		}

		recur(0, 0);

		bw.write(maxSize + "\n");
		bw.flush();
	}

	private static void recur(int size, int cnt) {
		if (cnt == 2) {
			maxSize = Math.max(maxSize, size);
			return;
		}

		for (Node rect : list) {
			if (visit[rect.id])
				continue;

			Node root = getRoot(rect);

			if (root == null)
				continue;

			put(root, rect, true);
			visit[rect.id] = true;
			recur(size + rect.h * rect.w, cnt + 1);
			put(root, rect, false);
			visit[rect.id] = false;
		}
	}

	private static Node getRoot(Node rect) {
		for (int y = 0; y <= h - rect.h; y++) {
			for (int x = 0; x <= w - rect.w; x++) {
				if (map[y][x])
					continue;

				boolean flag = true;
				loop: for (int i = y; i < y + rect.h; i++) {
					for (int j = x; j < x + rect.w; j++) {
						if (map[i][j]) {
							flag = false;
							break loop;
						}
					}
				}

				if (flag)
					return new Node(y, x, -1);
			}
		}

		return null;
	}

	private static void put(Node root, Node rect, boolean flag) {
		for (int i = root.h; i < root.h + rect.h; i++) {
			for (int j = root.w; j < root.w + rect.w; j++)
				map[i][j] = flag;
		}
	}

	private static class Node {
		int h, w, id;

		public Node(int h, int w, int id) {
			this.h = h;
			this.w = w;
			this.id = id;
		}
	}

}
