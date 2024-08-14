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

        br.readLine();
        String s;
        double d = 0;
        while ((s = br.readLine()) != null) d += calc(s);

        int i = (int) Math.round(d * 6 / 1000);
        sb.append(i / 60).append(":").append(i % 60 < 10 ? "0" : "").append(i % 60);

        bw.write(sb.toString());
        bw.flush();
    }

    private static double calc(String s) {
        String[] a = s.split(" ");

        return Math.sqrt(Math.pow(Integer.parseInt(a[2]) - Integer.parseInt(a[0]), 2) + Math.pow(Integer.parseInt(a[3]) - Integer.parseInt(a[1]), 2));
    }

}
