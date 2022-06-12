import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String[] comm = br.readLine().split(" ");

			if (comm[0].equals("push_front"))
				dq.push(Integer.parseInt(comm[1]));
			if (comm[0].equals("push_back")) {
				dq.offer(Integer.parseInt(comm[1]));
			}

			if (comm[0].equals("pop_front"))
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.removeFirst() + "\n");
			if (comm[0].equals("pop_back"))
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.removeLast() + "\n");

			if (comm[0].equals("size"))
				bw.write(dq.size() + "\n");
			if (comm[0].equals("empty"))
				if (dq.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");

			if (comm[0].equals("front"))
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.peekFirst() + "\n");
			if (comm[0].equals("back"))
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.peekLast() + "\n");
		}

		bw.flush();
	}

}
