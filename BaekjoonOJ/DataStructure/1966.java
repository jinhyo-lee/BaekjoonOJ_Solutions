import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			Queue<int[]> q = new LinkedList<>();
			for (int j = 0; j < n; j++)
				q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });

			int cnt = 0;
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				boolean chk = true;

				for (int[] comp : q) {
					if (tmp[1] < comp[1]) {
						chk = false;
						break;
					}
				}

				if (chk) {
					cnt++;
					if (tmp[0] == m)
						break;
				} else
					q.offer(tmp);
			}

			bw.write(cnt + "\n");
		}

		bw.flush();
	}

}
