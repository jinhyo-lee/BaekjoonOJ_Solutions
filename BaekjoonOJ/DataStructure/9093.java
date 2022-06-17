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

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			Stack<Character> stk = new Stack<>();
			StringBuilder sb = new StringBuilder();

			char[] input = br.readLine().toCharArray();
			for (char c : input) {
				if (c != ' ')
					stk.push(c);
				else {
					while (!stk.empty()) 
						sb.append(stk.pop());
					
					sb.append(' ');
				}
			}

			while (!stk.empty())
				sb.append(stk.pop());

			bw.write(sb + "\n");
		}

		bw.flush();
	}

}
