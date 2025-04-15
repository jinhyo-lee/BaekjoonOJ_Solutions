import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read() - 4;

        bw.write(isPossible());
        bw.flush();
    }

    private static String isPossible() {
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                if (i + j < 100 && count(i) + count(j) + count(i + j) == n)
                    return print(i) + '+' + print(j) + '=' + print(i + j);

        return "impossible";
    }

    private static int count(int i) {
        if (i < 10) return 6 + arr[i];
        int sum = 0;
        do sum += arr[i % 10]; while ((i /= 10) > 0);

        return sum;
    }

    private static String print(int i) {
        return i < 10 ? "0" + i : String.valueOf(i);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
