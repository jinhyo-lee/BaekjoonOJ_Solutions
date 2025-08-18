import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        bw.write(find(arr) ? "TAK" : "NIE");
        bw.flush();
    }

    private static boolean find(int[] arr) {
        for (int i = 2; i < arr.length; i++)
            if (arr[i - 2] != arr[i - 1] && arr[i - 1] != arr[i] && arr[i - 2] != arr[i]) return true;

        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
