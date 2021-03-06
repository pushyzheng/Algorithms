package leetcode.explore.binaryTree.preorderTraversal;

import leetcode.explore.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 利用迭代的方式先序遍历
 *
 * @author Pushy
 * @since 2019/1/26 12:19
 */
public class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return res;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            // 由于先序遍历是先访问左结点，所以需要右结点先入栈
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution2 solution = new Solution2();
        List<Integer> res = solution.preorderTraversal(root);
        System.out.println("res：" + res);
    }

}
