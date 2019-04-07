# 实现树

## 数据结构

很简单，只需要值和左右节点即可。

```java
class TreeNode<E> {
    E value;
    TreeNode<E> left, right;

    public TreeNode(E value) {
        this.value = value;
    }
}
```

## 构建树

按层遍历结果构建树。

2种方法基本上一样。

```java
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
```

## 层遍历

```java
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
```

## 中序遍历

- 递归算法非常简单，处理放中间

```java
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
```

- 非递归算法很难

```java
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
```

可见，递归算法的重要性。
