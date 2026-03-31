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
        String s = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < n; i++) arr[s.charAt(i) - 'a']++;

        char c = ' ';
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (max >= arr[i]) continue;
            max = arr[i];
            c = (char) (i + 'a');
        }

        bw.write(c + " " + max);
        bw.flush();
    }

}
