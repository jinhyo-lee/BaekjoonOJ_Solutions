import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(read());
        while (n-- > 0) sb.append(Integer.parseInt(read(), 2)).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static String read() throws IOException {
        sb.setLength(0);
        int c;
        while ((c = System.in.read()) > 47) sb.append((char) c);

        return sb.toString();
    }

}
