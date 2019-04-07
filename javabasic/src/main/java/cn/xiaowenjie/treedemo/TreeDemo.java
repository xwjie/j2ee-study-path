package cn.xiaowenjie.treedemo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeDemo {
    public static void main(String[] args) {
        // 按层遍历顺序构建树
        TreeNode<Integer> root = Tree.<Integer>buildTreee(1, 2, 3, 4, 5, 6, 7, 8);

        // 层遍历非递归
        levelWalk(root);
        System.out.println();

        // 递归中序遍历
        middleWalk(root);
        System.out.println();

        // 非递归中序遍历
//        middleWalk2(root);
//        System.out.println();

    }

    /**
     * 中序遍历
     * @param node
     */
    private static void middleWalk(TreeNode<Integer> node) {
        if(node.left != null){
            middleWalk(node.left);
        }

        System.out.print(node.value + ",");

        if(node.right != null){
            middleWalk(node.right);
        }
    }

    /**
     * 层遍历非递归
     * @param root
     */
    private static void levelWalk(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> que = new LinkedList<TreeNode<Integer>>();

        que.add(root);

        while(!que.isEmpty()) {

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
     * @param root
     */
    private static void middleWalk2(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> que = new LinkedList<TreeNode<Integer>>();

        que.add(root);

        while(!que.isEmpty()) {

            TreeNode<Integer> node = que.peek();

            if (node.left != null) {
                que.addFirst(node.left);
            }

            System.out.print(node.value + ",");

            if (node.right != null) {
                que.add(node.right);
            }
        }
    }
}
