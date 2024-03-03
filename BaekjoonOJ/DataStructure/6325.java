import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 1;
        String s;
        while (!(s = br.readLine()).equals("0")) {
            Set<Character> set = new TreeSet<>();
            set.add('a');

            int n = Integer.parseInt(s);
            while (n-- > 0) {
                char[] arr = br.readLine().toCharArray();
                char l = arr[0], r = arr[4];

                if (set.contains(r)) set.add(l);
                else set.remove(l);
            }

            sb.append("Program #").append(t++).append("\n");
            if (!set.isEmpty()) for (char c : set) sb.append(c).append(" ");
            else sb.append("none");
            sb.append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
