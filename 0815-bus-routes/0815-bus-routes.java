class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        // stop -> buses/routes containing this stop
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new ArrayList<>());
                }
                map.get(stop).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        q.add(source);
        visitedStops.add(source);
        int buses = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            buses++;
            while (size > 0) {
                int stop = q.poll();
                for (int bus : map.getOrDefault(stop, new ArrayList<>())) {
                    if (visitedBuses.contains(bus)) {
                        continue;
                    }
                    visitedBuses.add(bus);
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) {
                            return buses;
                        }
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            q.add(nextStop);
                        }
                    }
                }
                size--;
            }
        }
        return -1;
    }
}