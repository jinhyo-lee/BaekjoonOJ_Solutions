import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        bw.write(search(arr) ? "yes" : "no");
        bw.flush();
    }

    private static boolean search(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                for (int k = 0; k < arr.length; k++)
                    if (i != j && i != k && j != k && (arr[i] - arr[j]) % arr[k] != 0) return false;

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
