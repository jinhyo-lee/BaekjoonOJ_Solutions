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
        String a = br.readLine();
        String b = br.readLine();

        boolean flag = false;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!flag) cnt++;
                flag = true;
            } else flag = false;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
