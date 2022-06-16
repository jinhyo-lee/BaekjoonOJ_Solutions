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

		Stack<Character> stk = new Stack<>();
		Stack<Character> tmp = new Stack<>();

		String n = br.readLine();
		for (int i = 0; i < n.length(); i++)
			stk.push(n.charAt(i));

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");

			if (!stk.empty() && input[0].equals("L"))
				tmp.push(stk.pop());
			if (!tmp.empty() && input[0].equals("D"))
				stk.push(tmp.pop());
			if (!stk.empty() && input[0].equals("B"))
				stk.pop();
			if (input[0].equals("P"))
				stk.push(input[1].charAt(0));
		}

		while (!tmp.empty())
			stk.push(tmp.pop());

		StringBuilder sb = new StringBuilder();
		for (Character c : stk)
			sb.append(c);

		bw.write(sb + "\n");
		bw.flush();
	}

}
