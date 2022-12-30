import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] dna = new String[n];
        for (int i = 0; i < n; i++)
            dna[i] = br.readLine();

        StringBuilder sb = new StringBuilder();
        int hd = 0;
        int max;

        for (int i = 0; i < m; i++) {
            int[] cnt = new int[4];
            for (int j = 0; j < n; j++) {
                char tmp = dna[j].charAt(i);
                if (tmp == 'A')
                    cnt[0]++;
                else if (tmp == 'C')
                    cnt[1]++;
                else if (tmp == 'G')
                    cnt[2]++;
                else
                    cnt[3]++;
            }

            max = Math.max(cnt[0] > cnt[1] ? cnt[0] : cnt[1], cnt[2] > cnt[3] ? cnt[2] : cnt[3]);
            hd += n - max;

            if (max == cnt[0])
                sb.append('A');
            else if (max == cnt[1])
                sb.append('C');
            else if (max == cnt[2])
                sb.append('G');
            else
                sb.append('T');
        }


        bw.write(sb.append("\n").append(hd).toString());
        bw.flush();
    }

}
