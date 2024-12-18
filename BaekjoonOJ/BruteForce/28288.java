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

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'Y') arr[i]++;
        while (n-- > 1) for (int i = (s = br.readLine()).length() - 1; i >= 0; i--) if (s.charAt(i) == 'Y') arr[i]++;

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                sb.setLength(0);
                sb.append(i + 1);
            } else if (arr[i] == max) sb.append(",").append(i + 1);
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
