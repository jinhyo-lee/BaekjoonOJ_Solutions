import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int k;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k != 0) {
				arr = new int[k];
				visit = new boolean[k];
				
				for (int i = 0; i < k; i++)
					arr[i] = Integer.parseInt(st.nextToken());

				sb = new StringBuilder();
				recur(0, 0);

				bw.write(sb + "\n");
			} else
				break;
		}

		bw.flush();
	}

	private static void recur(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < k; i++) {
				if (visit[i])
					sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < k; i++) {
			visit[i] = true;
			recur(i + 1, depth + 1);
			visit[i] = false;
		}
	}

}
