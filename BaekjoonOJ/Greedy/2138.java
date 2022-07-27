import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n;
	static char[] input, target;
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		target = br.readLine().toCharArray();

		recur(1, 0);

		input[0] ^= 1;
		input[1] ^= 1;

		recur(1, 1);

		bw.write((minCnt == Integer.MAX_VALUE ? -1 : minCnt) + "\n");
		bw.flush();
	}

	private static void recur(int idx, int cnt) {
		if (idx == n) {
			if (input[idx - 1] == target[idx - 1])
				minCnt = Math.min(minCnt, cnt);

			return;
		}

		if (input[idx - 1] != target[idx - 1]) {
			swap(idx);
			recur(idx + 1, cnt + 1);
			swap(idx);
		} else
			recur(idx + 1, cnt);
	}

	private static void swap(int idx) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			if (i >= 0 && i < n)
				input[i] = (char) (input[i] ^ 1);
		}
	}

}
