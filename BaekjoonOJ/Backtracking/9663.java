import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		recur(0);

		bw.write(cnt + "\n");
		bw.flush();
	}

	private static void recur(int depth) {
		if (depth == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[depth] = i;

			if (check(depth))
				recur(depth + 1);
		}
	}

	private static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i])
				return false;
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
				return false;
		}

		return true;
	}
	
}
