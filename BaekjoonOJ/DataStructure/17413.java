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

		Stack<Character> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();
		for (int i = 0; i < input.length; i++) {
			if (input[i] != ' ' && input[i] != '<')
				stk.push(input[i]);
			else if (input[i] == '<') {
				while (!stk.empty())
					sb.append(stk.pop());

				int idx = i;
				while (input[idx] != '>') {
					sb.append(input[idx]);
					idx++;
				}
				sb.append('>');

				i = idx;
			} else {
				while (!stk.empty())
					sb.append(stk.pop());

				sb.append(' ');
			}
		}

		while (!stk.empty())
			sb.append(stk.pop());

		bw.write(sb + "\n");
		bw.flush();
	}

}
