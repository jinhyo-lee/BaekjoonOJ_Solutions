import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if (n == 1)
            bw.write("0");
        else {
            int[] score = new int[n];
            for (int i = n - 1; i >= 0; i--)
                score[i] = Integer.parseInt(br.readLine());

            int cnt = 0;
            for (int i = 1; i < n; i++) {
                if (score[i] >= score[i - 1]) {
                    int adjust = score[i] - score[i - 1] + 1;
                    cnt += adjust;
                    score[i] -= adjust;
                }
            }

            bw.write(String.valueOf(cnt));
        }

        bw.flush();
    }

}
