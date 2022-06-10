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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		bw.write(bfs(a, b) + "\n");
		bw.flush();
	}

	private static int bfs(long a, long b) {
		Queue<Long> q = new LinkedList<>();
		q.offer(a);

		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				long tmp = q.poll();
				
				if (tmp == b)
					return cnt + 1;
				if (tmp * 2 <= b)
					q.offer(tmp * 2);
				if (tmp * 10 + 1 <= b)
					q.offer(tmp * 10 + 1);
			}
			cnt++;
		}

		return -1;
	}

}
