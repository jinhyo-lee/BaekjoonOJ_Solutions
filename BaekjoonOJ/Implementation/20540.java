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

        for (char c : br.readLine().toCharArray()) sb.append(parse(c));

        bw.write(sb.toString());
        bw.flush();
    }

    private static char parse(char c) {
        if (c == 'E') return 'I';
        else if (c == 'I') return 'E';
        else if (c == 'S') return 'N';
        else if (c == 'N') return 'S';
        else if (c == 'T') return 'F';
        else if (c == 'F') return 'T';
        else if (c == 'J') return 'P';
        else return 'J';
    }

}
