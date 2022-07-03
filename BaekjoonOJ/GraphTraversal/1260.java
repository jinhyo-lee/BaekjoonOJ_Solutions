import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visit;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			list.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			list.get(y).add(x);
			list.get(x).add(y);
		}

		for (int i = 1; i <= n; i++)
			Collections.sort(list.get(i));

		visit = new boolean[n + 1];
		dfs(v);
		sb.append("\n");

		visit = new boolean[n + 1];
		bfs(v);

		bw.write(sb + "\n");
		bw.flush();
	}

	private static void dfs(int node) {
		if (visit[node])
			return;

		visit[node] = true;
		sb.append(node + " ");

		for (int i : list.get(node)) {
			if (!visit[i])
				dfs(i);
		}
	}

	private static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		visit[node] = true;

		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now + " ");

			for (int i : list.get(now)) {
				if (!visit[i]) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}

}
