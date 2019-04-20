package cn.xiaowenjie.treedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeDemo2 {
    public static void main(String[] args) {
        // 按层遍历顺序构建树
        TreeNode<Integer> root = Tree.<Integer>buildTreee(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(getFullPath(root, 10, null));
    }

    /**
     * 根据叶子节点的值得到完整的路径
     *
     * @param root
     * @param leafNode
     * @return
     */
    private static List<Integer> getFullPath(TreeNode<Integer> root, final int leafNode, Stack<Integer> list) {
        if (root == null) {
            return null;
        }

        if (list == null) {
            list = new Stack<Integer>();
        }

        list.add(root.value);

        // 找到
        if (root.value == leafNode) {
            return list;
        }

        // 往左边找
        List<Integer> list2 = getFullPath(root.left, leafNode, list);

        if (list2 != null) {
            return list2;
        }

        // 往右边找
        List<Integer> list3 = getFullPath(root.right, leafNode, list);

        if (list3 != null) {
            return list3;
        }

        // 这个节点没有找到，弹出
        list.pop();

        return null;
    }
}
