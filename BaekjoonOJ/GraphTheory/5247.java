import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while ((br.readLine()) != null) {
            Set<Character> node = new HashSet<>();
            boolean[][] graph = new boolean[26][26];

            String s;
            while (!(s = br.readLine()).equals("GRAPH END")) {
                char[] arr = s.replace(" ", "").toCharArray();
                for (char c : arr) node.add(c);

                int root = arr[0] - 'a';
                for (int i = 1; i < arr.length; i++)
                    graph[Math.min(root, arr[i] - 'a')][Math.max(root, arr[i] - 'a')] = true;
            }

            int cnt = 0;
            for (int i = 0; i < 26; i++) for (int j = i + 1; j < 26; j++) if (graph[i][j]) cnt++;

            sb.append("NODES ").append(node.size()).append(" EDGES ").append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
