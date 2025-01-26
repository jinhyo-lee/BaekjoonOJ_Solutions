import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        int cnt = 0;
        for (int i = 0; i < arr.length - 2; i++)
            for (int j = i + 1; j < arr.length - 1; j++)
                for (int k = j + 1; k < arr.length; k++) if (arr[i] * arr[j] == arr[k]) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
