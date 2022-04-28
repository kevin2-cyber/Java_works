package algol.loop;

import java.util.Stack;

public class GFG {
    public static void main(String[] args) {
        BST tree=new BST();
        tree.insert(30);
        tree.insert(50);
        tree.insert(15);
        tree.insert(20);
        tree.insert(10);
        tree.insert(40);
        tree.insert(60);
        tree.inorder();
    }
}

class Node {
    Node left;
    int val;
    Node right;
    Node(int val) {
        this.val = val;
    }
}

class  BST {
    Node root;

    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node prev = null;
        Node temp = root;
        while (temp != null) {
            if (temp.val > key) {
                prev = temp;
                temp = temp.left;
            } else if (temp.val < key) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.val > key){
            prev.left = node;
        } else {
            prev.right = node;
        }
    }

    public void inorder() {
        Node temp = root;
        Stack<Node> stack = new Stack<>();
        while (temp != null || stack.isEmpty()) {
            if (temp != null) {
                stack.add(temp);
                System.out.println("temp = " + temp.val);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.println(" " + temp.val);
                temp = temp.right;
            }
        }
    }
}
