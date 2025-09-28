import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());
        while (p-- > 0) {
            s = br.readLine();
            final int n = s.length() - 2;
            int[] arr = new int[8];
            for (int i = 0; i < n; i++) arr[index(i)]++;

            for (int i : arr) sb.append(i).append(' ');
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int index(int i) {
        return (s.charAt(i) == 'H' ? 4 : 0) + (s.charAt(i + 1) == 'H' ? 2 : 0) + (s.charAt(i + 2) == 'H' ? 1 : 0);
    }

}
