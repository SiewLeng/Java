// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution_6 {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/

    /* 
    public static int height(Node root) {
        if (root == null) return -1;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        return (lHeight >= rHeight) ? lHeight + 1: rHeight + 1;
    }
    */

    /* 
	public static int height(Node root) {
        if (root.left == null && root.right == null) return 0;
        int lHeight = (root.left != null) ? height(root.left) : -1;
        int rHeight = (root.right != null) ? height(root.right) : -1;
        return (lHeight >= rHeight) ? lHeight + 1: rHeight + 1;
    }
    */

    public static int height(Node root) {
        ArrayList<ArrayList<Node>> all_level_nodes = new ArrayList<>();
        int index = 0;
        ArrayList<Node> first_level_nodes = new ArrayList<>();
        first_level_nodes.add(root);
        all_level_nodes.add(first_level_nodes);
        while (all_level_nodes.size() == index + 1) {
            ArrayList<Node> curr_level_nodes = all_level_nodes.get(index);
            ArrayList<Node> new_level_nodes = new ArrayList<>();
            for (int i = 0; i < curr_level_nodes.size(); i++) {
                Node curr = curr_level_nodes.get(i);
                if (curr.left != null) new_level_nodes.add(curr.left);
                if (curr.right != null) new_level_nodes.add(curr.right);
            }
            if (!new_level_nodes.isEmpty()) all_level_nodes.add(new_level_nodes);
            index++;
        }
        return  all_level_nodes.size() - 1;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}