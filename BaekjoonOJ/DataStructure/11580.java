import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Pair> set = new HashSet<>();
        set.add(new Pair(0, 0));
        int l = Integer.parseInt(br.readLine()), y = 0, x = 0;
        String s = br.readLine();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (c == 'E') x++;
            else if (c == 'W') x--;
            else if (c == 'S') y++;
            else y--;
            set.add(new Pair(y, x));
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    private static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return y == p.y && x == p.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

}
