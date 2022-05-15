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

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] check;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.get(x).add(y);
			list.get(y).add(x);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(list.get(i));
		}

		check = new boolean[n + 1];
		dfs(v);
		bw.write("\n");

		check = new boolean[n + 1];
		bfs(v);

		bw.flush();
	}

	public static void dfs(int visit) throws IOException {
		if (check[visit])
			return;

		check[visit] = true;
		bw.write(visit + " ");

		for (int i : list.get(visit)) {
			if (!check[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int start) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		check[start] = true;

		while (!q.isEmpty()) {
			int visit = q.poll();
			bw.write(visit + " ");

			for (int i : list.get(visit)) {
				if (!check[i]) {
					check[i] = true;
					q.offer(i);
				}
			}
		}
	}

}
