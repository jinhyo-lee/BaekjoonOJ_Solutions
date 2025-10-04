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

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            int i = s.indexOf(' ');
            sb.append(s, 0, i + 1).append(grade(Integer.parseInt(s.substring(i + 1))));
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String grade(int i) {
        if (i >= 97) return "A+\n";
        else if (i >= 90) return "A\n";
        else if (i >= 87) return "B+\n";
        else if (i >= 80) return "B\n";
        else if (i >= 77) return "C+\n";
        else if (i >= 70) return "C\n";
        else if (i >= 67) return "D+\n";
        else if (i >= 60) return "D\n";
        else return "F\n";
    }

}
