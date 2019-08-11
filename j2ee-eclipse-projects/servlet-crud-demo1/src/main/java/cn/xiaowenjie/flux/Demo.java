package cn.xiaowenjie.flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(35);
        list.add(55);
        list.add(25);

        Optional<Integer> max = list.stream().max((s1, s2) -> s1 - s2);
        System.out.println(max.get());
    }
}
