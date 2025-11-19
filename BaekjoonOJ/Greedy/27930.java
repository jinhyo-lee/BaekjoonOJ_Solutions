import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(find(br.readLine().toCharArray()));
        bw.flush();
    }

    private static String find(char[] arr) {
        char[] a = {'Y', 'O', 'N', 'S', 'E', 'I'}, b = {'K', 'O', 'R', 'E', 'A'};
        int i = 0, j = 0;
        for (char c : arr) {
            if (a[i] == c && ++i == 6) return "YONSEI";
            if (b[j] == c && ++j == 5) return "KOREA";
        }

        return "";
    }

}
