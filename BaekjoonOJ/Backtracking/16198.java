import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int n;
	static List<Integer> list = new ArrayList<>();
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			list.add(Integer.parseInt(input[i]));

		recur(0);
		
		bw.write(max + "\n");
		bw.flush();
	}

	private static void recur(int energy) {
		if (list.size() == 2) {
			max = Math.max(max, energy);
			return;
		}

		for (int i = 1; i < list.size() - 1; i++) {
			int e = list.get(i - 1) * list.get(i + 1);

			int tmp = list.get(i);
			list.remove(i);
			recur(energy + e);
			list.add(i, tmp);
		}
	}
	
}
