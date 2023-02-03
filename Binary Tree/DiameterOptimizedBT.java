public class DiameterOptimizedBT {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        int diam;
        int ht;
        Info(int diam, int ht)
        {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameterOp(Node root)
    {
        if(root == null)
        {
            return new Info(0, 0);
        }

        Info leftInfo = diameterOp(root.left);
        Info righInfo = diameterOp(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam),
                                    leftInfo.ht + righInfo.ht+1);

        int height = Math.max(leftInfo.ht, righInfo.ht) + 1;


        return new Info(diam, height);
    }

    public static void main(String[] args) {
        //           1
        //         /   \
        //        2     3   
        //      /  \  /  \
        //     4   5 6    7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameterOp(root).ht);
    }
}
