import java.util.HashMap;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Sohum Berry
 */

public class WeatherPatterns {
    public static int[] temps;
    // Mapping index in the temperatures array to the length of the streak
    public static HashMap<Integer, Integer> lengthMap = new HashMap<>();

    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        temps = temperatures;

        return recursive(temperatures[0], Integer.MIN_VALUE, 0, 0);
    }

    public static int recursive(int nowNum, int prevNum, int length, int pos) {
        if (nowNum <= prevNum) {
            return length;
        }

        int maxStreak = 0;
        for (int i = pos; i < temps.length; i++) {
            if (lengthMap.get(i) == null || lengthMap.get(i) < length+1) {
                lengthMap.put(i, length + 1);
                maxStreak = Math.max(maxStreak, recursive(temps[i], nowNum, length + 1, i));
            }
        }

        return maxStreak;
    }
}
