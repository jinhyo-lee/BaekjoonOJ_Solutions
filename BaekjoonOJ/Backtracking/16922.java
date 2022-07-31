import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n, cnt;
	static int[] num = { 1, 5, 10, 50 };
	static boolean[] visit = new boolean[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		recur(0, 0, 0);

		bw.write(cnt + "\n");
		bw.flush();
	}

	private static void recur(int idx, int sum, int depth) {
		if (depth == n) {
			if (!visit[sum]) {
				visit[sum] = true;
				cnt++;
			}

			return;
		}

		for (int i = idx; i < 4; i++)
			recur(i, sum + num[i], depth + 1);
	}

}
