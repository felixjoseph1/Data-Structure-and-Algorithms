package Test;

import java.util.*;

// Server class with Comparable implementation
class Server implements Comparable<Server> {
    int weightage;
    int index;
    int freeTime;

    public Server(int weightage, int index) {
        this.weightage = weightage;
        this.index = index;
        this.freeTime = 0;
    }

    @Override
    public int compareTo(Server other) {
        if (this.freeTime == other.freeTime) {
            if (this.weightage == other.weightage) {
                return this.index - other.index;
            }
            return this.weightage - other.weightage;
        }
        return this.freeTime - other.freeTime;
    }

    @Override
    public String toString() {
        return "Server{" +
                "w=" + weightage +
                ", idx=" + index +
                ", freeTime=" + freeTime +
                '}';
    }
}

// Solution class
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        PriorityQueue<Server> pq = new PriorityQueue<>();
        int ans[] = new int[tasks.length];

        for (int i = 0; i < n; i++) {
            pq.add(new Server(servers[i], i));
        }

        for (int i = 0; i < tasks.length; i++) {
            // Reinsert servers that are free by current time
            for (int j = 0; j < n; j++) {
                Server server = pq.poll();
                if (server.freeTime == i) server.freeTime = 0;
                pq.add(server);
            }

            Server server = pq.poll();
            ans[i] = server.index;
            server.freeTime = i + tasks[i];
            pq.add(server);

            System.out.println("Task " + i + " assigned to Server " + server.index + " (free at " + server.freeTime + ")");
        }

        return ans;
    }
}

// Main class to run and debug
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};

        int[] result = sol.assignTasks(servers, tasks);

        System.out.println("Final assignment:");
        System.out.println(Arrays.toString(result));
    }
}
