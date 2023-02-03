public class sumofNodeofBT {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right=null;
        }
    }


    static class BinaryTree
    {
        static int idx  = -1;

        public Node Buildtree(int nodes[])
        {
            idx++;
            if(nodes[idx] == -1)
            {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = Buildtree(nodes);
            newNode.right = Buildtree(nodes);

            return newNode;
        }

        public int sumofBT(Node root)
        {
            if(root == null)
            {
                return 0;
            }

            int lsum = sumofBT(root.left);
            int rsum = sumofBT(root.right);
            return lsum+rsum+root.data;
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.Buildtree(nodes);
        System.out.println(tree.sumofBT(root));


    }
}
