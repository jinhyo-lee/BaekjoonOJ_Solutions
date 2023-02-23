import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String input;
    static int len, max;
    static List<Integer> list;
    static boolean[] visit;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine();

        len = input.length();
        max = len < 10 ? len : (len - 9) / 2 + 9;

        list = new ArrayList<>();
        visit = new boolean[51];

        recur(0);
    }

    private static void recur(int depth) throws IOException {
        if (depth == len) {
            for (int i : list)
                bw.write(i + " ");

            bw.flush();
            System.exit(0);
        }

        StringBuilder perm = new StringBuilder();
        for (int i = depth; i <= depth + 1; i++) {
            if (input.length() > i)
                perm.append(input.charAt(i));
            int num = Integer.parseInt(perm.toString());

            if (num > max || visit[num])
                continue;

            visit[num] = true;
            list.add(num);
            recur(i + 1);
            visit[num] = false;
            list.remove(list.size() - 1);
        }
    }

}
