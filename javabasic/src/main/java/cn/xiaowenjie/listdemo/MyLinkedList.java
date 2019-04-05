package cn.xiaowenjie.listdemo;

import java.util.List;

public class MyLinkedList<E> implements IList<E> {

    class ListNode<E> {
        E value;
        ListNode<E> next, pre;

        public ListNode(E e) {
            this.value = e;
        }
    }

    private ListNode<E> head, tail;

    private int size;

    public MyLinkedList() {
        super();
    }

    public void add(E... e) {
        if (e == null) {
            doAdd(null);
        } else {
            for (int i = 0; i < e.length; i++) {
                doAdd(e[i]);
            }
        }
    }

    private void doAdd(E e) {
        ListNode<E> node = new ListNode<E>(e);

        if (this.head == null) {
            this.head = node;

            this.tail = this.head;
        } else {
            this.tail.next = node;
            node.pre = this.tail;

            this.tail = node;
        }

        this.size++;
    }

    public E remove(E e) {
        if (this.head == null) {
            return null;
        }

        ListNode<E> current = this.head;

        while (current != null) {
            // 找到了
            if (equalValue(current.value, e)) {
                // 是头结点
                if (current.pre == null) {
                    this.head = current.next;
                } else {
                    current.pre.next = current.next;
                }

                // 是否到了最后一个
                if (current.next != null) {
                    current.next.pre = current.pre;
                } else {
                    this.tail = current;
                }

                this.size--;
                return e;
            }

            current = current.next;
        }

        return null;
    }

    private boolean equalValue(E value, E e) {
        if (value == null) {
            return e == null;
        }

        return value.equals(e);
    }

    public int size() {
        return this.size;
    }

    public E get(int index) {
        if (index > this.size) {
            throw new IllegalArgumentException();
        }

        ListNode<E> current = this.head;

        int i = 0;

        while (i < index) {
            current = current.next;
            i++;
        }

        return current.value;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("[");

        ListNode<E> current = this.head;

        while (current != null) {
            sb.append(current.value);

            if (current.next != null) {
                sb.append(",");
            }

            current = current.next;
        }

        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }
}
