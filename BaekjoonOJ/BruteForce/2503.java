import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static Info[] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new Info[n];

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[n] = new Info(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        generatePermutation(new StringBuilder(), new boolean[10]);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void generatePermutation(StringBuilder perm, boolean[] visit) {
        if (perm.length() == 3) {
            for (Info info : arr) {
                if (!isCorrect(info, perm))
                    return;
            }
            cnt++;

            return;
        }

        for (int i = 1; i < 10; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            perm.append(i);
            generatePermutation(perm, visit);
            perm.deleteCharAt(perm.length() - 1);
            visit[i] = false;
        }
    }

    private static boolean isCorrect(Info info, StringBuilder perm) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (info.guess.charAt(i) == perm.charAt(j)) {
                    if (i == j)
                        strike++;
                    else
                        ball++;
                }
            }
        }

        return info.strike == strike && info.ball == ball;
    }

    private static class Info {
        String guess;
        int strike, ball;

        public Info(String guess, int strike, int ball) {
            this.guess = guess;
            this.strike = strike;
            this.ball = ball;
        }
    }

}
