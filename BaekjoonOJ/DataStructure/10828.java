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

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			String[] comm = br.readLine().split(" ");
			
			if (comm[0].equals("push"))
				stk.push(Integer.parseInt(comm[1]));
			if (comm[0].equals("pop"))
				if (stk.empty())
					bw.write(-1 + "\n");
				else
					bw.write(stk.pop() + "\n");
			
			if (comm[0].equals("size"))
				bw.write(stk.size() + "\n");
			if (comm[0].equals("empty"))
				if (stk.empty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
			
			if (comm[0].equals("top"))
				if (stk.empty())
					bw.write(-1 + "\n");
				else
					bw.write(stk.peek() + "\n");
		}

		bw.flush();
	}

}
