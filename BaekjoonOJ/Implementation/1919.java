import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];
        String a = br.readLine(), b = br.readLine();
        for (int i = 0; i < a.length(); i++) arr[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++) arr[b.charAt(i) - 'a']--;

        int sum = 0;
        for (int i : arr) if (i != 0) sum += Math.abs(i);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
