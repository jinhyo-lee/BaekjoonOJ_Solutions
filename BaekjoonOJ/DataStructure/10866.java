import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			String[] comm = br.readLine().split(" ");

			switch (comm[0]) {
			case "push_front":
				dq.offerFirst(Integer.parseInt(comm[1]));
				break;
			case "push_back":
				dq.offerLast(Integer.parseInt(comm[1]));
				break;

			case "pop_front":
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.pollFirst() + "\n");
				break;
			case "pop_back":
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.pollLast() + "\n");
				break;

			case "size":
				bw.write(dq.size() + "\n");
				break;
			case "empty":
				if (dq.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
				break;
				
			case "front":
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.peekFirst() + "\n");
				break;
			case "back":
				if (dq.isEmpty())
					bw.write(-1 + "\n");
				else
					bw.write(dq.peekLast() + "\n");
				break;
			}
		}

		bw.flush();
	}

}
