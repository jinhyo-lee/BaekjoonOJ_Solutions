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

        boolean flag = true;
        int indent = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == '}') {
                indent--;
                if (!flag) sb.append('\n');
                flag = true;
            }

            if (flag) {
                for (int i = indent; i > 0; i--) sb.append("  ");
                flag = false;
            }
            sb.append(c);

            if (c == '{' || c == ',') {
                if (c == '{') indent++;
                sb.append('\n');
                flag = true;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
