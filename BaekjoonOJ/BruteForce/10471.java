import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] visit = new boolean[read() + 1];
        int[] arr = new int[read() + 2];
        arr[arr.length - 1] = visit.length - 1;
        for (int i = 1; i < arr.length - 1; i++) arr[i] = read();

        for (int i = 0; i < arr.length; i++) for (int j = i + 1; j < arr.length; j++) visit[arr[j] - arr[i]] = true;
        for (int i = 0; i < visit.length; i++) if (visit[i]) sb.append(i).append(' ');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
