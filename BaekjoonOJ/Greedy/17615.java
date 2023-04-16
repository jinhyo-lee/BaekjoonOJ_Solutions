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
        String input = br.readLine();

        int red = 0, blue = 0;
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'R')
                red++;
            else
                blue++;
        }
        int min = Math.min(red, blue);

        char first = input.charAt(0);
        char last = input.charAt(n - 1);

        int cnt = 1;
        while (cnt < n && input.charAt(cnt) == first)
            cnt++;

        min = first == 'R' ? Math.min(min, red - cnt) : Math.min(min, blue - cnt);

        cnt = 1;
        while (cnt < n && input.charAt(n - 1 - cnt) == last)
            cnt++;

        min = last == 'R' ? Math.min(min, red - cnt) : Math.min(min, blue - cnt);

        bw.write(String.valueOf(min));
        bw.flush();
    }

}
