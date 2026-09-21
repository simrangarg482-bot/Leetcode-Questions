class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        // Build graph and indegree
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());
            for (String ingredient : ingredients.get(i)) {
                if (!graph.containsKey(ingredient)) {
                    graph.put(ingredient, new ArrayList<>());
                }
                graph.get(ingredient).add(recipe);
            }
        }
        Queue<String> q = new LinkedList<>();
        // Initially available supplies
        for (String supply : supplies) {
            q.add(supply);
        }
        List<String> ans = new ArrayList<>();
        // Kahn's Algorithm
        while (!q.isEmpty()) {
            String current = q.remove();
            if (!graph.containsKey(current)) {
                continue;
            }
            for (String recipe : graph.get(current)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    ans.add(recipe);
                    q.add(recipe);
                }
            }
        }
        return ans;
    }
}