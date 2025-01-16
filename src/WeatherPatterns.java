/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Sohum Berry
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {

        return recursive(temperatures[0], Integer.MIN_VALUE, 0, 0, temperatures);
    }

    public static int recursive(int nowNum, int prevNum, int length, int pos, int[] temperatures) {
        if (nowNum <= prevNum) {
            return length;
        }

        int maxStreak = 0;
        for (int i = pos; i < temperatures.length; i++) {
            maxStreak = Math.max(maxStreak, recursive(temperatures[i], nowNum, length+1, i, temperatures));
        }

        return maxStreak;
    }
}
