import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[] a = {1967, 1969, 1970, 1971, 1972, 1973, 1973, 1974, 1975, 1976, 1977, 1977, 1979, 1980, 1983, 1984, 1987, 1993, 1995, 1997, 1999, 2002, 2003, 2013, 2016};
    static String[] b = {"DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory", "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars", "AladdinSane", "PinUps", "DiamondDogs", "YoungAmericans", "StationToStation", "Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps", "LetsDance", "Tonight", "NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside", "Earthling", "Hours", "Heathen", "Reality", "TheNextDay", "BlackStar"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String s = br.readLine();
            int i = s.indexOf(' ');
            find(Integer.parseInt(s.substring(0, i)), Integer.parseInt(s.substring(i + 1)), sb);
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void find(int s, int e, StringBuilder sb) {
        StringBuilder tmp = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < 25; i++) {
            if (a[i] < s || a[i] > e) continue;
            tmp.append(a[i]).append(' ').append(b[i]).append('\n');
            cnt++;
        }

        sb.append(cnt).append('\n').append(tmp);
    }

}
