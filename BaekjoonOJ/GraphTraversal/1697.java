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

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (n == k)
			bw.write(0 + "\n");
		else
			bw.write(bfs(n, k) + "\n");

		bw.flush();
	}

	private static int bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);

		int[] chk = new int[100001];
		chk[n] = 1;
		
		int result = 0;
		loop:
		while (!q.isEmpty()) {
			int loc = q.poll();
			for (int i = 0; i < 3; i++) {
				int move;

				if (i == 0)
					move = loc + 1;
				else if (i == 1)
					move = loc - 1;
				else
					move = loc * 2;

				if (move == k) {
					result = chk[loc];
					break loop;
				}

				if (move >= 0 && move < chk.length && chk[move] == 0) {
					q.offer(move);
					chk[move] = chk[loc] + 1;
				}
			}
		}

		return result;
	}

}
