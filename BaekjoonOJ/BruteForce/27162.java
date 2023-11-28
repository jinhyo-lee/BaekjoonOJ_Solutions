import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> def = new HashMap<>();
        int key;
        for (int i = 0; i < 3; i++) def.put(key = Integer.parseInt(st.nextToken()), def.getOrDefault(key, 0) + 1);

        int a = 1, b = 1, max = 0;
        while (a != 6 || b != 7) {
            if (b == 7) {
                a++;
                b = 1;
            }

            map = new HashMap<>(def);
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b++, 0) + 1);

            for (int i = 0; i < 12; i++) if (s.charAt(i) == 'Y') max = Math.max(max, choose(i));
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int choose(int rule) {
        int sum = 0;
        switch (rule) {
            case 0:
                return map.getOrDefault(1, 0);
            case 1:
                return map.getOrDefault(2, 0) * 2;
            case 2:
                return map.getOrDefault(3, 0) * 3;
            case 3:
                return map.getOrDefault(4, 0) * 4;
            case 4:
                return map.getOrDefault(5, 0) * 5;
            case 5:
                return map.getOrDefault(6, 0) * 6;
            case 6:
                for (int key : map.keySet()) if (map.get(key) == 4) return map.get(key) * key;
                return 0;
            case 7:
                if (map.size() != 2) return 0;
                else {
                    boolean flag = false;
                    for (int key : map.keySet()) {
                        int value = map.get(key);
                        if (value == 3 || value == 2) flag = true;
                        sum += value * key;
                    }
                    return flag ? sum : 0;
                }
            case 8:
                for (int key : map.keySet()) if (map.get(key) != 1 || key == 6) return 0;
                return 30;
            case 9:
                for (int key : map.keySet()) if (map.get(key) != 1 || key == 1) return 0;
                return 30;
            case 10:
                for (int key : map.keySet()) if (map.get(key) == 5) return 50;
                return 0;
            default:
                for (int key : map.keySet()) sum += map.get(key) * key;
                return sum;
        }
    }

}
