import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visit = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++)
			list.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			list.get(y).add(x);
			list.get(x).add(y);
		}

		int cnt = 0;
		for (int i = 1; i < n + 1; i++) {
			if (dfs(i))
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	private static boolean dfs(int node) {
		if (visit[node])
			return false;
		else {
			visit[node] = true;
			for (int i = 0; i < list.get(node).size(); i++) {
				int next = list.get(node).get(i);
				if (!visit[next])
					dfs(next);
			}

			return true;
		}
	}

}
