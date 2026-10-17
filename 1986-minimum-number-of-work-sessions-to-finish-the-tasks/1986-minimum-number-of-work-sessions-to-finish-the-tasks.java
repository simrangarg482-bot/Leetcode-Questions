import java.util.Arrays;

class Solution {
    private int helper(int i, int[] tasks, int[] sessions,
                       int count, int sessionTime) {

        if (i == tasks.length) {
            return count;
        }

        int min = tasks.length;

        for (int j = 0; j < count; j++) {

            // Skip sessions having the same current load
            boolean duplicate = false;
            for (int k = 0; k < j; k++) {
                if (sessions[k] == sessions[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) continue;

            if (sessions[j] + tasks[i] <= sessionTime) {
                sessions[j] += tasks[i];

                min = Math.min(min, helper(
                    i + 1, tasks, sessions, count, sessionTime
                ));

                sessions[j] -= tasks[i];
            }
        }

        // Open one new session
        sessions[count] = tasks[i];

        min = Math.min(min, helper(
            i + 1, tasks, sessions, count + 1, sessionTime
        ));

        sessions[count] = 0;

        return min;
    }

    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);

        for (int i = 0; i < tasks.length / 2; i++) {
            int temp = tasks[i];
            tasks[i] = tasks[tasks.length - 1 - i];
            tasks[tasks.length - 1 - i] = temp;
        }

        int[] sessions = new int[tasks.length];

        return helper(0, tasks, sessions, 0, sessionTime);
    }
}