package cn.xiaowenjie;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserService {

    private Map<Integer, User> userMap = new LinkedHashMap<Integer, User>();

    public User createUser(String name, int age){
        User user = new User(name, age);

        userMap.put(user.getId(), user);

        return user;
    }

    public boolean updateUser(int id, String name, int age){
        User user = userMap.get(id);

        if(user == null){
            return false;
        }

        user.setName(name);
        user.setAge(age);

        return true;
    }

    public User deleteUser(int id){
        return userMap.remove(id);
    }

    public Collection<User> queryAllUser(){
        return userMap.values();
    }

    public User queryById(int id) {
        return userMap.get(id);
    }
}
