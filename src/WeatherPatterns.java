import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Sohum Berry
 */

public class WeatherPatterns {
    public static ArrayList[] adjacencyList;
    public static int[] memoizationMap;

    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        adjacencyList = new ArrayList[temperatures.length];
        memoizationMap = new int[temperatures.length];

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    adjacencyList[j].add(i);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < temperatures.length; i++) {
            max = Math.max(max, getLongestPath(i));
        }
        return max;
    }

    public static int getLongestPath(int vertex) {
         if (memoizationMap[vertex] != 0) {
             return memoizationMap[vertex];
         }

        int len = 0;
        for (int i = 0; i < adjacencyList[vertex].size(); i++) {
            len = Math.max(len, getLongestPath((Integer) adjacencyList[vertex].get(i)));
        }
        memoizationMap[vertex] = len + 1;

        return len + 1;
    }
}
