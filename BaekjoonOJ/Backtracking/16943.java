import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static String a;
	static int b;
	static int res = -1;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = st.nextToken();
		b = Integer.parseInt(st.nextToken());
		visit = new boolean[a.length()];

		recur("", 0);

		bw.write(res + "\n");
		bw.flush();
	}

	private static void recur(String c, int depth) {
		if (depth == a.length()) {
			res = Math.max(res, Integer.parseInt(c));
			
			return;
		}

		for (int i = 0; i < a.length(); i++) {
			if (visit[i])
				continue;
			if (a.charAt(i) - '0' == 0 && depth == 0)
				continue;
			if (Integer.parseInt(c + a.charAt(i)) > b)
				continue;

			visit[i] = true;
			recur(c + a.charAt(i), depth + 1);
			visit[i] = false;
		}
	}

}
