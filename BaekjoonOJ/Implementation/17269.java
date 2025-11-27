import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        String s = br.readLine(), a = s.substring(0, s.indexOf(' ')), b = s.substring(s.indexOf(' ') + 1);

        int[] cnt = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1}, arr = new int[a.length() + b.length()];
        for (int i = 0, j = 0, k = 0; k < arr.length; ) {
            if (i < a.length()) arr[k++] = cnt[a.charAt(i++) - 'A'];
            if (j < b.length()) arr[k++] = cnt[b.charAt(j++) - 'A'];
        }

        for (int i = arr.length; i > 2; i--) for (int j = 0; j < i - 1; j++) arr[j] = (arr[j] + arr[j + 1]) % 10;

        bw.write((arr[0] > 0 ? String.valueOf(arr[0]) : "") + arr[1] + '%');
        bw.flush();
    }

}
