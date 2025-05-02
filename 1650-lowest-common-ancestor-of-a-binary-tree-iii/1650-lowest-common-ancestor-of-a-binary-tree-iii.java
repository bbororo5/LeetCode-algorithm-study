/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Deque<Node> pAncestors = findAncestors(p);
        Deque<Node> qAncestors = findAncestors(q);

        Node lca = null;

        while (!pAncestors.isEmpty() && !qAncestors.isEmpty()) {
            Node pAncestor = pAncestors.pollFirst();
            Node qAncestor = qAncestors.pollFirst();

            if (pAncestor == qAncestor) { 
                lca = pAncestor; 
            } else {
                break;
            }

        }

        return lca;
    }

    private Deque<Node> findAncestors(Node node) {
        Deque<Node> ancestors = new ArrayDeque<>();
        Node current = node;
        while (current != null) {
            ancestors.addFirst(current);
            current = current.parent;
        }

        return ancestors;
    }
} 