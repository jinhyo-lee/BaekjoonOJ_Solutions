import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] inputk = st.nextToken().toCharArray();
		char[] inputs = st.nextToken().toCharArray();
		int n = Integer.parseInt(st.nextToken());

		king k = new king(inputk[0] - 64, inputk[1] - 48);
		stone s = new stone(inputs[0] - 64, inputs[1] - 48);

		int movex = 0;
		int movey = 0;
		for (int i = 0; i < n; i++) {
			String comm = br.readLine();
			if (comm.equals("R")) {
				movex = 1; movey = 0;
			}
			if (comm.equals("L")) {
				movex = -1; movey = 0;
			}
			if (comm.equals("B")) {
				movex = 0; movey = -1;
			}
			if (comm.equals("T")) {
				movex = 0; movey = 1;
			}
			if (comm.equals("RT")) {
				movex = 1; movey = 1;
			}
			if (comm.equals("LT")) {
				movex = -1; movey = 1;
			}
			if (comm.equals("RB")) {
				movex = 1; movey = -1;
			}
			if (comm.equals("LB")) {
				movex = -1; movey = -1;
			}

			if (k.x + movex > 8 || k.y + movey > 8 || k.x + movex < 1 || k.y + movey < 1)
				continue;

			if (k.x + movex == s.x && k.y + movey == s.y) {
				if (s.x + movex > 8 || s.y + movey > 8 || s.x + movex < 1 || s.y + movey < 1)
					continue;
				else
					s = new stone(s.x + movex, s.y + movey);
			}

			k = new king(k.x + movex, k.y + movey);
		}

		bw.write((char) (k.x + 64) + "" + (char) (k.y + 48) + "\n");
		bw.write((char) (s.x + 64) + "" + (char) (s.y + 48) + "\n");
		bw.flush();
	}

	private static class king {
		int x;
		int y;

		king(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class stone {
		int x;
		int y;

		stone(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
