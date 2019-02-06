package site.pushy.algorithms.leetcode.explore.binaryTree.postorderTraversal;

import site.pushy.algorithms.leetcode.explore.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用遍历和栈结构实现二叉树的后序遍历
 *
 * @author Pushy
 * @since 2019/1/26 15:02
 */
public class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> ansStack = new Stack<>();

        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ansStack.push(root);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }

        while (!ansStack.isEmpty()) {
            res.add(ansStack.pop().val);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution2 solution = new Solution2();
        List<Integer> res = solution.postorderTraversal(root);
        System.out.println("res：" + res);
    }

}
