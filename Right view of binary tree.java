//User function Template for Java


/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/


class Solution{
    //Function to return list containing elements of right view of binary tree.
   
public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

// If it's the rightmost node at this level, add it to the result list
                if (i == levelSize - 1) {
                    result.add(current.data);
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return result;}
}
