import java.util.*;

public class BinaryTreePostorderTraversal {

    // Definition for binary tree node
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        postorder(root, res);

        return res;
    }

    private static void postorder(TreeNode node, List<Integer> res) {

        if (node == null) {
            return;
        }

        postorder(node.left, res);

        postorder(node.right, res);

        res.add(node.val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        List<Integer> result = postorderTraversal(root);

        System.out.println("Postorder Traversal:");

        System.out.println(result);
    }
}