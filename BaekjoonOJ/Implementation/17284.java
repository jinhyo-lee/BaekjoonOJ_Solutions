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

        int[] arr = {0, 500, 800, 1000};
        int n = 5000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) n -= arr[Integer.parseInt(st.nextToken())];

        bw.write(String.valueOf(n));
        bw.flush();
    }

}
