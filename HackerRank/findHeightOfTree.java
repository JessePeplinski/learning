/* Taken from https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem */

import java.util.*;
import java.io.*;
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

class findHeightOfTree {
    /*
    7 -- number of nodes
    3
    5
    2
    1
    4
    6
    7
    */
	static int height(Node root) {
        if(root == null) {
            return -1;
        }
        else {
            int leftDeep = height(root.left);
            int rightDeep = height(root.right);
            
            if(leftDeep > rightDeep) {
                return (leftDeep + 1);
            }
            else {
                return (rightDeep + 1);
            }
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
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
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}