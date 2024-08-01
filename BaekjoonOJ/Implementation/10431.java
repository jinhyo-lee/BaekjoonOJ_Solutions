import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int p = read();
        while (p-- > 0) {
            sb.append(read()).append(" ");
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) arr[i] = read();

            int cnt = 0;
            for (int i = 1; i < 20; i++) for (int j = 0; j < i; j++) if (arr[i] < arr[j]) cnt++;
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
