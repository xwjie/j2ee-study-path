package cn.xiaowenjie.listdemo;

public interface IList<E> {
    public void add(E... e);

    public E remove(E e);

    public int size();

    public E get(int index);
}
