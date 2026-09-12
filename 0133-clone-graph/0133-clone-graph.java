/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        mp.put(node, new Node(node.val, new ArrayList<>()));
        q.add(node);
        while(q.size() > 0) {
            Node front = q.poll();
            for(Node n: front.neighbors) {
                if(!mp.containsKey(n)) {
                    mp.put(n, new Node(n.val, new ArrayList<>()));
                    q.add(n);
                }
                mp.get(front).neighbors.add(mp.get(n));
            }
        }
        return mp.get(node);
    }
}