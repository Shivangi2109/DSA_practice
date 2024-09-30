
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


class Clone_Graph {
    public Node cloneGraph(Node node) {
        if(node==null)
        {
            return node;
        }
         HashMap<Node,Node> hm=new HashMap<>();
         return clone(hm,node);
    }
    public Node clone(HashMap<Node,Node> hm ,Node node)
    {
       Node newNode=new Node(node.val);
       hm.put(node,newNode);
       for(Node neighbor:node.neighbors)
       {
        if(!hm.containsKey(neighbor))
        {
            //not cloned
            newNode.neighbors.add(clone(hm,neighbor));
        }
        else
        {
            //when the nodes are already clones
            newNode.neighbors.add(hm.get(neighbor));
        }
       }
       return newNode;
    }
}