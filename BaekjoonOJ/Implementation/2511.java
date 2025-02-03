import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] A = new int[10], B = new int[10];
        for (int i = 0; i < 10; i++) A[i] = read();
        for (int i = 0; i < 10; i++) B[i] = read();

        int a = 0, b = 0;
        char c = 'D';
        for (int i = 0; i < 10; i++) {
            if (A[i] > B[i]) {
                a += 3;
                c = 'A';
            } else if (A[i] < B[i]) {
                b += 3;
                c = 'B';
            } else {
                a++;
                b++;
            }
        }

        bw.write(sb.append(a).append(" ").append(b).append("\n").append(a > b ? "A" : a < b ? "B" : c).toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
