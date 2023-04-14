import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        bw.write(String.valueOf(getCount(input)));
        bw.flush();
    }

    private static int getCount(String input) {
        if (input.length() % 5 != 0)
            return -1;

        String quack = " quack";

        int[] cnt = new int[6];
        cnt[0] = input.length();

        int max = 0;
        for (char c : input.toCharArray()) {
            for (int i = 1; i <= 5; i++) {
                if (c == quack.charAt(i)) {
                    if (cnt[i - 1] == 0)
                        return -1;

                    cnt[i]++;
                    cnt[i - 1]--;
                }
            }
            max = Math.max(max, cnt[1] + cnt[2] + cnt[3] + cnt[4]);
        }

        return cnt[5] * 5 == input.length() ? max : -1;
    }

}
