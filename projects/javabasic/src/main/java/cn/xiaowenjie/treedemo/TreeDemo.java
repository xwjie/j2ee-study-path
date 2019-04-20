package cn.xiaowenjie.treedemo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeDemo {
    public static void main(String[] args) {
        // 按层遍历顺序构建树
        TreeNode<Integer> root = Tree.<Integer>buildTreee(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 层遍历非递归
        System.out.println("层遍历非递归");
        levelWalk(root);
        System.out.println();

        // 递归中序遍历
        System.out.println("递归中序遍历");
        middleWalk(root);
        System.out.println();

        // 非递归中序遍历
        System.out.println("非递归中序遍历");
        middleWalk2(root);
        System.out.println();
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private static void middleWalk(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        middleWalk(node.left);

        System.out.print(node.value + ",");

        middleWalk(node.right);
    }

    /**
     * 层遍历非递归
     *
     * @param root
     */
    private static void levelWalk(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> que = new LinkedList<TreeNode<Integer>>();

        que.add(root);

        while (!que.isEmpty()) {

            TreeNode<Integer> node = que.pop();

            if (node.left != null) {
                que.add(node.left);
            }

            System.out.print(node.value + ",");

            if (node.right != null) {
                que.add(node.right);
            }
        }
    }

    /**
     * 中序遍历非递归
     * <p>
     * 1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
     * 2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子；
     * 3)直到P为NULL并且栈为空则遍历结束
     *
     * @param root
     */
    private static void middleWalk2(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        TreeNode<Integer> node = root;

        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);

                node = node.left;
            }

            if (!stack.empty()) {
                node = stack.pop();
                System.out.print(node.value + ",");

                node = node.right;
            }
        }
    }
}
