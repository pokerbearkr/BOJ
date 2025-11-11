package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1991 {
    private static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }

    private final Map<Character, Node> nodeMap = new HashMap<>();
    private Node root;

    public void addNode(char parent, char left, char right) {
        Node parentNode = nodeMap.computeIfAbsent(parent, Node::new);
        if (root == null) {
            root = parentNode;
        }

        if (left != '.') {
            parentNode.left = nodeMap.computeIfAbsent(left, Node::new);
        }
        if (right != '.') {
            parentNode.right = nodeMap.computeIfAbsent(right, Node::new);
        }
    }

    public void preorder(Node node, StringBuilder result) {
        if (node == null) return;
        result.append(node.value);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public void inorder(Node node, StringBuilder result) {
        if (node == null) return;
        inorder(node.left, result);
        result.append(node.value);
        inorder(node.right, result);
    }

    public void postorder(Node node, StringBuilder result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.append(node.value);
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BOJ1991 tree = new BOJ1991();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tree.addNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        StringBuilder preorderResult = new StringBuilder();
        StringBuilder inorderResult = new StringBuilder();
        StringBuilder postorderResult = new StringBuilder();

        tree.preorder(tree.getRoot(), preorderResult);
        tree.inorder(tree.getRoot(), inorderResult);
        tree.postorder(tree.getRoot(), postorderResult);

        System.out.println(preorderResult);
        System.out.println(inorderResult);
        System.out.println(postorderResult);
    }
}