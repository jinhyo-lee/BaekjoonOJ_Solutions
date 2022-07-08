import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int n;
	static int[] arr;
	static boolean[] visit;
	static int[] result;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visit = new boolean[n];
		result = new int[n];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		recur(0);

		bw.write(max + "\n");
		bw.flush();
	}
	
	private static void recur(int depth) {
		if (depth == n) {
			setMax(result);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				result[depth] = arr[i];

				visit[i] = true;
				recur(depth + 1);
				visit[i] = false;
			}
		}
	}

	private static void setMax(int[] result) {
		int tmp = 0;

		for (int i = 0; i < n - 1; i++)
			tmp += Math.abs(result[i] - result[i + 1]);

		max = Math.max(max, tmp);
	}

}
