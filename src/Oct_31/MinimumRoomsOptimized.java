package Nov_31_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumRoomsOptimized {

    public static void main(String args[]) {

        MinimumRoomsOptimized minRoom = new MinimumRoomsOptimized();
        int[][] intervals = {{}};
        System.out.println(minRoom.minimumNumberOfRooms(intervals));
    }

    public int minimumNumberOfRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int count = 0;
        for (int[] interval : intervals) {

            if (priorityQueue.isEmpty()) {
                System.out.println("Count: " + count);
                count++;
                priorityQueue.offer(interval[1]);
            } else {
                if (interval[0] >= priorityQueue.peek()) {
                    priorityQueue.poll();
                } else {
                    count++;
                }
                priorityQueue.offer(interval[1]);
            }
        }

        return count++;
    }
}
