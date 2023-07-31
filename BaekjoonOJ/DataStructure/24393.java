import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Main {

    static Deque<Boolean> deck = new ArrayDeque<>(), left = new ArrayDeque<>(), right = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        deck.addAll(Collections.nCopies(26, false));
        deck.push(true);

        int n = read() + 1;

        while (n-- > 1) shuffle();
        while (n++ < 27) if (deck.pop()) break;

        bw.write(String.valueOf(n));
        bw.flush();
    }

    private static void shuffle() throws IOException {
        for (int i = 0; i < 13; i++)
            left.offer(deck.pop());

        for (int i = 0; i < 14; i++)
            right.offer(deck.pop());

        boolean flag = true;
        while (deck.size() < 27) {
            int i = read();

            if (flag) while (i-- > 0) deck.offer(right.pop());
            else while (i-- > 0) deck.offer(left.pop());

            flag = !flag;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
