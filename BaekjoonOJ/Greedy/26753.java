import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = {'o', 'i', 'j'};
        int c, i = 0, cnt = 0;
        while ((c = System.in.read()) > 13) {
            if (arr[i] == c && ++i == 3) {
                i = 0;
                cnt++;
            }
        }

        bw.write(cnt > 0 ? String.valueOf(cnt) : "NIE");
        bw.flush();
    }

}
