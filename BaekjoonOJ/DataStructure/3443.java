import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = init();
        String s;
        int g = 1;
        do {
            String p1 = br.readLine(), p2 = br.readLine();
            p1 = p1.substring(p1.indexOf(' ') + 1);
            p2 = p2.substring(p2.indexOf(' ') + 1);

            int c1 = 0, c2 = 0;
            while ((s = br.readLine()).length() > 1) {
                int i = s.indexOf(' '), v1 = map.get(s.substring(0, i)), v2 = map.get(s.substring(i + 1));
                if (v1 == v2) continue;
                if ((v1 == 0 && v2 == 1) || (v1 == 1 && v2 == 2) || (v1 == 2 && v2 == 0)) c1++;
                else c2++;
            }

            sb.append("Game #").append(g++).append(":\n").append(p1).append(": ").append(c1).append(c1 == 1 ? " point\n" : " points\n").append(p2).append(": ").append(c2).append(c2 == 1 ? " point\n" : " points\n").append(c1 == c2 ? "TIED GAME" : c1 > c2 ? "WINNER: " + p1 : "WINNER: " + p2).append("\n\n");
        } while (s.charAt(0) != '.');

        bw.write(sb.toString());
        bw.flush();
    }

    private static Map<String, Integer> init() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Kamen", 0);
        map.put("Rock", 0);
        map.put("Pierre", 0);
        map.put("Stein", 0);
        map.put("Ko", 0);
        map.put("Koe", 0);
        map.put("Sasso", 0);
        map.put("Roccia", 0);
        map.put("Guu", 0);
        map.put("Kamien", 0);
        map.put("Piedra", 0);
        map.put("Nuzky", 1);
        map.put("Scissors", 1);
        map.put("Ciseaux", 1);
        map.put("Schere", 1);
        map.put("Ollo", 1);
        map.put("Olloo", 1);
        map.put("Forbice", 1);
        map.put("Choki", 1);
        map.put("Nozyce", 1);
        map.put("Tijera", 1);
        map.put("Papir", 2);
        map.put("Paper", 2);
        map.put("Feuille", 2);
        map.put("Papier", 2);
        map.put("Carta", 2);
        map.put("Rete", 2);
        map.put("Paa", 2);
        map.put("Papel", 2);

        return map;
    }

}
