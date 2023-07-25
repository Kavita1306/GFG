

/* A binary tree node has data, pointer to left child
   and a pointer to right child  
struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
    
    Node(int x){
        data = x;
        left = right = NULL;
    }
}; */


//Function to return a list containing the level order traversal in spiral form.
// Function to find height of the binary tree


//Function to find the height of the tree.
int height(struct Node *root)
{
    //base case for recursion.
    if(root==NULL)
        return 0;

    //finding height of left subtree recursively.
    int l = 1+height(root->left);

    //finding height of right subtree recursively.
    int r=1+height(root->right);
    
    //taking the maximum as height of tree.
    if(l>r)
        return l;
    else
        return r;

}

//Function to do level order traversal of tree in spiral form.
void spiral(vector<int> &vec, struct Node *root,int level ,int flag)
{
    //base case for recursion.
    if(root==NULL)
        return;

    //if level is 1, we push the data in the list.
    if(level==1)
        vec.push_back(root->data);

    else if(level>1)
    {
        //if flag is true, we call the spiral function recursively for the
        //left subtrees first and then for right subtrees.
        if(flag)
        {
            spiral(vec,root->left,level-1,flag);
            spiral(vec,root->right,level-1,flag);
        }
        //else we call for right subtrees first and then left subtrees.
        else
        {
            spiral(vec,root->right,level-1,flag);
            spiral(vec, root->left,level-1,flag);
        }
    }
}

//Function to return a list containing the level order traversal in spiral form.
vector<int> findSpiral(struct Node *root)
{
    if(root==NULL){
        vector<int> vec;
        return vec;
    }

    int h = height(root);
    bool flag = false;

    //for each level, we do the spiral traversal.
    vector<int> vec;
    for(int i=1;i<=h;i++)
    {
        spiral(vec,root,i,flag);
        flag=!flag;
    }
    
    //returning the list.
    return vec;
}
