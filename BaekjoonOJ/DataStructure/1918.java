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

		String input = br.readLine();

		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);

			if (now == '+' || now == '-' || now == '*' || now == '/') {
				while (!stk.empty() && priority(stk.peek()) >= priority(now))
					sb.append(stk.pop());

				stk.push(now);
			} else if (now == '(') {
				stk.push(now);
			} else if (now == ')') {
				while (!stk.empty() && stk.peek() != '(')
					sb.append(stk.pop());

				stk.pop();
			} else {
				sb.append(now);
			}
		}

		while (!stk.empty())
			sb.append(stk.pop());

		bw.write(sb + "\n");
		bw.flush();
	}

	private static int priority(char oper) {
		if (oper == '(')
			return 0;
		else if (oper == '+' || oper == '-')
			return 1;
		else
			return 2;
	}

}
