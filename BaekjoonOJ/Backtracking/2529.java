import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int n;
	static char[] sign;
	static boolean[] visit = new boolean[10];
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		sign = br.readLine().replaceAll(" ", "").toCharArray();

		recur("", 0);

		bw.write(result.get(result.size() - 1) + "\n" + result.get(0));
		bw.flush();
	}

	private static void recur(String num, int idx) {
		if (idx == n + 1) {
			result.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (visit[i])
				continue;

			if (idx == 0 || compare(num.charAt(idx - 1) - '0', i, sign[idx - 1])) {
				visit[i] = true;
				recur(num + i, idx + 1);
				visit[i] = false;
			}
		}
	}

	private static boolean compare(int prev, int now, char sign) {
		if (sign == '<')
			return prev < now;
		else
			return prev > now;
	}

}
