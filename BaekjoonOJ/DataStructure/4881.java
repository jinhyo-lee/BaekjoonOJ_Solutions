import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a, b;
        while ((a = read()) != 0 && (b = read()) != 0) {
            sb.append(a).append(" ").append(b).append(" ");

            List<Integer> A = new ArrayList<>(), B = new ArrayList<>();

            A.add(a);
            while (!A.contains(a = generate(a))) A.add(a);

            B.add(b);
            while (!B.contains(b = generate(b))) B.add(b);

            sb.append(compare(A, B)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int generate(int n) {
        int sum = 0;
        do sum += (n % 10) * (n % 10); while ((n /= 10) > 0);

        return sum;
    }

    private static int compare(List<Integer> A, List<Integer> B) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++)
            for (int j = 0, a = A.get(i); j < B.size(); j++)
                if (a == B.get(j)) min = Math.min(min, i + j);

        return min != Integer.MAX_VALUE ? min + 2 : 0;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
