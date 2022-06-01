import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		char[][] board = new char[5][15];

		for (int i = 0; i < board.length; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				board[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[j][i] == '\0')
					continue;
				sb.append(board[j][i]);
			}
		}

		bw.write(sb + "\n");
		bw.flush();
	}

}
