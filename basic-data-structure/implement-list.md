# 实现list

只实现最基本的add,remove,size,get方法，初学者这节课最少6个小时时间实现，不要高估自己能力和低估难度。

这节课是第一次的动手实现功能，非常重要，除了实现功能，更加重要的考虑各种场景，把函数写好，把代码写短。

你能用多少行代码实现list？

## 创建项目

可以直接在IDE里面创建项目，也可以使用Maven创建。

maven命令
```
mvn archetype:generate -DgroupId=cn.xiaowenjie -DartifactId=javabasic -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## 定义接口

实现JDK的list接口对于初学者来说难度太大，这里我们自己定义一个。

```java
public interface IList<E> {
    public void add(E... e);

    public E remove(E e);

    public int size();

    public E get(int index);
}
```

## 实现

### 双链表实现

双链表实现相对比较简单。

### 单链表实现

### 数组实现

