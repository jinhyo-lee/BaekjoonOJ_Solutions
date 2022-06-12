import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		int back = 0;
		for (int i = 0; i < n; i++) {
			String[] comm = br.readLine().split(" ");
			
			if (comm[0].equals("push")) {
				q.offer(Integer.parseInt(comm[1]));
				back = Integer.parseInt(comm[1]);
			}
			if (comm[0].equals("pop"))
				if (q.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(q.poll() + "\n");

			if (comm[0].equals("size"))
				bw.write(q.size() + "\n");
			if (comm[0].equals("empty"))
				if (q.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");

			if (comm[0].equals("front"))
				if (q.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(q.peek() + "\n");
			if (comm[0].equals("back"))
				if (q.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(back + "\n");
		}

		bw.flush();
	}

}
