class Solution {
    
    int treeSize = 0;
    void getLength(Node root)
    {
        if(root==null)return;
        getLength(root.left);
        treeSize++;
        getLength(root.right);
    }

    void generateArray(Node root, int ancestors[])
    {
        ancestors[root.data] = -1;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            if (temp.left!=null)
            {
                ancestors[temp.left.data] = temp.data;
                q.add(temp.left);
            }
            if (temp.right!=null)
            {
                ancestors[temp.right.data] = temp.data;
                q.add(temp.right);
            }
        } 
    }

    int kthAncestorUtil(Node root, int n, int k, int node)
    {
        int ancestors[] = new int[n+1];
        generateArray(root,ancestors);
        int count = 0;
        while (node!=-1)
        { 
            node = ancestors[node];
            count++;
            if(count==k)break;
        }
        return node;
    } 

    public int kthAncestor(Node root, int k, int node)
    {
        // Code here
        getLength(root);
        return kthAncestorUtil(root, treeSize, k, node);
    }
}
