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

        int[] arr = new int[26];
        String s;
        while ((s = br.readLine()) != null) for (char c : s.replace(" ", "").toCharArray()) arr[c - 'a']++;

        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (max > arr[i]) continue;
            if (max < arr[i]) {
                max = arr[i];
                sb.setLength(0);
            }
            sb.append((char) ('a' + i));
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
