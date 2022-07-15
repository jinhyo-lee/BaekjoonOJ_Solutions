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
	static int dest; 
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		visit = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++)
			list.add(new ArrayList<>());

		st = new StringTokenizer(br.readLine());
		int root = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.get(x).add(y);
			list.get(y).add(x);
		}

		dfs(root, 0);

		bw.write(result + "\n");
		bw.flush();
	}

	private static void dfs(int node, int cnt) {
		if (node == dest) {
			result = cnt;
			return;
		}
			
		visit[node] = true;
		for (int next : list.get(node)) {
			if (!visit[next]) 
				dfs(next, cnt + 1);
		}
	}

}
