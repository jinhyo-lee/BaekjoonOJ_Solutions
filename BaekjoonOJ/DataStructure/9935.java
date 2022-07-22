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
		String exp = br.readLine();
		int expLen = exp.length();

		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			stk.push(input.charAt(i));
			
			if (stk.size() >= expLen) {
				boolean flag = true;
				
				for (int j = 0; j < expLen; j++) {
					if (stk.get(stk.size() - expLen + j) != exp.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					for (int j = 0; j < expLen; j++) 
						stk.pop();
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (Character c : stk) 
			sb.append(c);
		
		bw.write(sb.length() == 0? "FRULA" : sb + "\n");
		bw.flush();
	}

}
