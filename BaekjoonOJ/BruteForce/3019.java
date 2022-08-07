import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int c, p, cnt;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        map = new int[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++)
            map[i] = Integer.parseInt(st.nextToken());

        switch (p) {
            case 1:
                cnt += c;
                check("0000");
                break;
            case 2:
                check("00");
                break;
            case 3:
                check("110");
                check("01");
                break;
            case 4:
                check("011");
                check("10");
                break;
            case 5:
                check("000");
                check("10");
                check("010");
                check("01");
                break;
            case 6:
                check("000");
                check("00");
                check("100");
                check("02");
                break;
            case 7:
                check("000");
                check("20");
                check("001");
                check("00");
                break;
        }

        bw.write(cnt + "\n");
        bw.flush();
    }

    private static void check(String block) {
        int len = block.length();

        for (int i = 0; i <= c - len; i++) {
            int gap = block.charAt(0) - '0' + map[i];

            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (block.charAt(j) - '0' + map[i + j] != gap) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                cnt++;
        }
    }

}
