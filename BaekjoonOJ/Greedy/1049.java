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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int bundle = 1000, piece = 1000;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            bundle = Math.min(bundle, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        if (bundle > piece * 6)
            bw.write(String.valueOf(piece * n));
        else
            bw.write(String.valueOf(bundle * (n / 6) + Math.min(bundle, piece * (n % 6))));

        bw.flush();
    }

}
