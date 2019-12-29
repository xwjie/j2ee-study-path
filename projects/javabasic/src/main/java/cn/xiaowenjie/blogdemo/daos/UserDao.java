package cn.xiaowenjie.blogdemo.daos;

import cn.xiaowenjie.blogdemo.beans.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class UserDao {

    private final static UserDao instance = new UserDao();

    private final static Map<Long, User> users = new HashMap<>();

    private final static AtomicLong idSeq = new AtomicLong(100L);

    private UserDao(){

    }

    public static UserDao getInstance() {
        return instance;
    }

    public long add(User user){
        long newId = idSeq.getAndIncrement();

        user.setId(newId);

        users.put(newId, user);

        return newId;
    }

    public User queryByName(String name){
        return users.values().stream().filter(user -> name.equals(user.getName())).findFirst().orElse(null);
    }
}
