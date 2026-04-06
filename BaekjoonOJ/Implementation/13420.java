import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            int i = s.indexOf(' ');
            sb.append(calc(Long.parseLong(s.substring(0, i)), s.charAt(i + 1), Long.parseLong(s.substring(i + 3, s.indexOf(' ', i + 3)))) == Long.parseLong(s.substring(s.lastIndexOf(' ') + 1)) ? "correct\n" : "wrong answer\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static long calc(long a, char o, long b) {
        return o == '+' ? a + b : o == '-' ? a - b : o == '*' ? a * b : a / b;
    }

}
