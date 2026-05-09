// https://www.geeksforgeeks.org/dsa/find-the-maximum-sum-path-in-a-binary-tree/

// Java program to find maximum sum leaf to 
// root path in Binary Tree
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class MaxPathSum {
    // Function to return the maximum sum path from root to leaf
    static int maxPathSumCal(Node root) {
        if (root == null) return 0;
        int left_maxPath = maxPathSumCal(root.left);
        int right_maxPath = maxPathSumCal(root.right);
        return (left_maxPath >= right_maxPath) ? left_maxPath + root.data : right_maxPath + root.data;
    }

    public static void main(String[] args) {
      
        // Constructing tree:
        //           10
        //         /    \
        //       -2      7
        //      /  \
        //     8   -4
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        
        /* 
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        */

        int sum = maxPathSumCal(root);
        System.out.println(sum);
    }
}