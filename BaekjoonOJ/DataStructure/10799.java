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
		char[] input = br.readLine().toCharArray();

		int result = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '(')
				stk.push(input[i]);
			if (input[i] == ')') {
				stk.pop();
				if (input[i - 1] == '(')
					result += stk.size();
				else
					result++;
			}
		}

		bw.write(result + "\n");
		bw.flush();
	}

}
