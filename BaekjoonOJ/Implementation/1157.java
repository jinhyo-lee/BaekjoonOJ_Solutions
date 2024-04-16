import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) arr[s.charAt(i) - (s.charAt(i) < 'a' ? 'A' : 'a')]++;

        int max = 0, c = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                c = i;
            } else if (arr[i] == max) c = -2;
        }

        bw.write(String.valueOf((char) (c + 'A')));
        bw.flush();
    }

}
