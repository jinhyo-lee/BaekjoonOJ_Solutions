import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<String> list = new ArrayList<>();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            float max = 0;
            while (n-- > 0) {
                String s = br.readLine();
                int i = s.indexOf(' ');
                float f = Float.parseFloat(s.substring(i + 1));
                if (max < f) {
                    max = f;
                    list.clear();
                    list.add(s.substring(0, i));
                } else if (max == f) list.add(s.substring(0, i));
            }

            for (String s : list) sb.append(s).append(' ');
            sb.append('\n');

            list.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
