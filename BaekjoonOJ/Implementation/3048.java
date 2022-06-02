import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		Ant[] grp1 = new Ant[n1 + 1];
		Ant[] grp2 = new Ant[n2 + 1];

		String input = br.readLine();
		for (int i = n1 - 1; i >= 0; i--) {
			grp1[i] = new Ant(input.charAt(n1 - i - 1), 1);
		}

		input = br.readLine();
		for (int i = 0; i < n2; i++) {
			grp2[i] = new Ant(input.charAt(i), -1);
		}

		Ant[] start = new Ant[n1 + n2];
		for (int i = 0; i < n1; i++)
			start[i] = grp1[i];
		for (int i = n1; i < n1 + n2; i++)
			start[i] = grp2[i - n1];
		
		int t = Integer.parseInt(br.readLine());
		Ant[] end = start;
		for (int i = 0; i < t; i++) {
			Ant[] cur = end.clone();
			for (int j = 0; j < n1 + n2 - 1; j++) {
				if (cur[j].dir == 1 && cur[j + 1].dir == -1) {
					Ant tmp = cur[j];
					end[j] = cur[j + 1];
					end[j + 1] = tmp;
				} else
					continue;
			}
		}

		for (int i = 0; i < n1 + n2; i++)
			sb.append(end[i].val);

		bw.write(sb.toString());
		bw.close();
	}

	private static class Ant {
		char val;
		int dir;

		public Ant(char val, int dir) {
			this.val = val;
			this.dir = dir;
		}
	}
	
}
