import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> list;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

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

		check = new boolean[n + 1];
		
		bw.write(bfs(1) + "\n");
		bw.flush();
	}

	public static int bfs(int start) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		check[start] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int visit = q.poll();
			
			for (int i : list.get(visit)) {
				if (!check[i]) {
					check[i] = true;
					q.offer(i);
					cnt++;
				}
			}
		}

		return cnt;
	}

}
