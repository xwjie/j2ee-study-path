package cn.xiaowenjie.treedemo;

import java.util.*;


class TreeNode<E> {
    E value;
    TreeNode<E> left, right;

    public TreeNode(E value) {
        this.value = value;
    }
}

public class Tree {

    private Tree() {

    }

    /**
     * 按层遍历结果构建树
     * 使用队列
     *
     * @param elements
     * @param <E>
     * @return
     */
    public static <E> TreeNode<E> buildTreee(E... elements) {
        // Deque<TreeNode<E>> list = new LinkedList<TreeNode<E>>();
        Deque<TreeNode<E>> list = new ArrayDeque<TreeNode<E>>();

        TreeNode<E> root = new TreeNode<E>(elements[0]);

        list.add(root);

        for (int i = 1; i < elements.length; i++) {
            E value = elements[i];

            TreeNode<E> node = new TreeNode<E>(value);

            TreeNode<E> firstNode = list.peek();

            if (firstNode.left == null) {
                firstNode.left = node;
            } else if (firstNode.right == null) {
                firstNode.right = node;
                // 删除第一个
                list.pop();
            }

            list.add(node);
        }

        // 返回root
        return root;
    }

    /**
     * 按层遍历结果构建树
     * 使用List
     * @param elements
     * @param <E>
     * @return
     */
    public static <E> TreeNode<E> buildTreee2(E... elements){
        List<TreeNode<E>> list = new ArrayList<TreeNode<E>>(elements.length);

        TreeNode<E> root = null;


        for (int i = 0; i < elements.length; i++) {
            E value = elements[i];

            TreeNode<E> node = new TreeNode<E>(value);

            if(root == null){
                root = node;
            }

            if(!list.isEmpty()){
                TreeNode<E> firstNode = list.get(0);

                if(firstNode.left == null){
                    firstNode.left = node;
                }
                else if(firstNode.right == null){
                    firstNode.right = node;
                    list.remove(0);
                }
            }

            list.add(node);
        }

        // 返回root
        return root;
    }
}
