import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine(), a = br.readLine(), b = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(' '))), m = Integer.parseInt(s.substring(s.indexOf(' ') + 1));

        char[] arr = new char[m];
        for (int i = 0; i < n; i++) arr[i + m - n] = a.charAt(i);
        for (int i = m - 1; i >= n; i--) arr[i - n] = toChar((toInt(b.charAt(i)) - toInt(arr[i]) + 26) % 26);

        bw.write(arr);
        bw.flush();
    }

    private static int toInt(char c) {
        return c - 'a';
    }

    private static char toChar(int i) {
        return (char) (i + 'a');
    }

}
