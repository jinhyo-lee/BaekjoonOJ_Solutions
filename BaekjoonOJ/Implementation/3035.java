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

        String[] arr = br.readLine().split(" ");
        int r = Integer.parseInt(arr[0]), zr = Integer.parseInt(arr[2]), zc = Integer.parseInt(arr[3]);
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < zr; j++, sb.append('\n'))
                for (char c : s.toCharArray()) for (int k = 0; k < zc; k++) sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
