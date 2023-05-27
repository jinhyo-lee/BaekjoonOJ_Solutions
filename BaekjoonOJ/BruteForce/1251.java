import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int len = s.length();

        List<String> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++)
                list.add(combine(s, i, j));
        }

        Collections.sort(list);

        bw.write(list.get(0));
        bw.flush();
    }

    private static String combine(String s, int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuilder(s.substring(0, i)).reverse());
        sb.append(new StringBuilder(s.substring(i, j)).reverse());
        sb.append(new StringBuilder(s.substring(j)).reverse());

        return sb.toString();
    }

}
