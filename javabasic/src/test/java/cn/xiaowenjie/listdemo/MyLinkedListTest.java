package cn.xiaowenjie.listdemo;


public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<String>();

        list.add("1", "2", "3");
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(1));

        list.add("1","2","5");

        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(0));

        list.remove("1");

        System.out.println(list.size());
        System.out.println(list);

        list.remove("1");

        System.out.println(list.size());
        System.out.println(list);

        list.remove("5");

        System.out.println(list.size());
        System.out.println(list);

        list.remove("999");

        System.out.println(list.size());
        System.out.println(list);

        list.add(null);

        System.out.println(list.size());
        System.out.println(list);

        list.remove(null);

        System.out.println(list.size());
        System.out.println(list);
    }
}
