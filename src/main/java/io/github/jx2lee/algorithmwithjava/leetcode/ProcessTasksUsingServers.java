package io.github.jx2lee.algorithmwithjava.leetcode;

import java.util.*;

// https://leetcode.com/problems/process-tasks-using-servers/
// https://leetcode.com/problems/process-tasks-using-servers/discuss/1239762/Java-TreeMap-%2B-PriorityQueue
public class ProcessTasksUsingServers {

    public int[] assignTasks(int[] servers, int[] tasks) {
        // System.out.println("Arrays.toString(servers) = " + Arrays.toString(servers));
        PriorityQueue<int []> freeServers = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new int[]{i, servers[i]});
        }

        // System.out.println("freeServers = " + Arrays.deepToString(freeServers.toArray()));

        TreeMap<Integer, List<int[]>> busyServers = new TreeMap<>();
        int[] assigned = new int[tasks.length];
        int freeTime = 0;

        for (int i = 0; i < tasks.length; i++) {
            freeTime = Math.max(freeTime, i);
            while (!busyServers.isEmpty() && busyServers.firstKey() <= freeTime) {
                freeServers.addAll(busyServers.pollFirstEntry().getValue());
                // System.out.println("while 절 addAll 이후 freeServers = " + Arrays.deepToString(freeServers.toArray()));
            }

            if (freeServers.isEmpty()) {
                freeTime = busyServers.firstKey();
                freeServers.addAll(busyServers.pollFirstEntry().getValue());
                // System.out.println("if 절 addAll 이후 freeServers = " + Arrays.deepToString(freeServers.toArray()));
            }

            int[] server = freeServers.poll();
            assigned[i] = server[0];
            busyServers.computeIfAbsent(freeTime + tasks[i], ignored -> new ArrayList<>()).add(server);
        }

        System.out.println("assigned = " + Arrays.toString(assigned));
        return assigned;
    }

    public static void main(String[] args) {

        // int[] servers = new int[]{3, 3, 2};
        // int[] tasks = new int[]{1, 2, 3, 2, 1, 2};
        int[] servers = new int[]{5,1,4,3,2};
        int[] tasks = new int[]{2,1,2,4,5,2,1};

        ProcessTasksUsingServers processTasksUsingServers = new ProcessTasksUsingServers();
        processTasksUsingServers.assignTasks(servers, tasks);
    }
}
