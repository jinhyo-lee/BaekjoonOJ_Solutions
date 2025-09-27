import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(dayOfWeek(read(), read()));
        bw.flush();
    }

    private static String dayOfWeek(int d, int m) {
        String s = LocalDate.of(2009, m, d).getDayOfWeek().toString();

        return s.charAt(0) + s.substring(1).toLowerCase();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
