import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) 
			bw.write(valid(br.readLine()) + "\n");

		bw.flush();
	}

	private static String valid(String input) {
		Stack<Character> stk = new Stack<>();
		
		for (Character c : input.toCharArray()) {
			if (c == '(')
				stk.push(c);
			else if (stk.empty())
				return "NO";
			else
				stk.pop();
		}

		if (!stk.empty())
			return "NO";
		else
			return "YES";
	}

}
