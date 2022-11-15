import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] stock = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                stock[i] = Integer.parseInt(st.nextToken());

            int max = 0;
            long earn = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (stock[i] > max)
                    max = stock[i];
                else
                    earn += max - stock[i];
            }

            bw.write(earn + "\n");
        }

        bw.flush();
    }

}
