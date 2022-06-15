import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];

		for (int i = 0; i < n; i++)
			input[i] = Integer.parseInt(br.readLine());

		Stack<Integer> stk = new Stack<>();

		int num = 1;
		int idx = 0;
		while (num <= n) {
			stk.push(num);
			sb.append("+\n");
			num++;

			while (!stk.empty() && stk.peek() == input[idx]) {
				stk.pop();
				sb.append("-\n");
				idx++;
			}
		}

		if (stk.empty())
			bw.write(sb + "");
		else
			bw.write("NO" + "");

		bw.flush();
	}

}
