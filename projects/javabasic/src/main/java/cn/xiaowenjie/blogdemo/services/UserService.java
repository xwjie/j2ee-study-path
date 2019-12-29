package cn.xiaowenjie.blogdemo.services;

import cn.xiaowenjie.blogdemo.beans.User;
import cn.xiaowenjie.blogdemo.daos.UserDao;
import cn.xiaowenjie.blogdemo.exceptions.LoginException;
import cn.xiaowenjie.blogdemo.util.Check;
import cn.xiaowenjie.blogdemo.util.UserTool;

public class UserService {

    private final static UserService instance = new UserService();

    private final UserDao dao = UserDao.getInstance();

    private UserService(){

    }

    public static UserService getInstance() {
        return instance;
    }


    public User addUser(User user){
        Check.notNull(user);
        Check.notEmpty(user.getName());
        Check.notEmpty(user.getPassword());

        // 重复创建
        Check.check(dao.queryByName(user.getName()) == null, "user exist {}", user.getName());

        long newId = dao.add(user);

        user.setId(newId);

        System.out.printf("add user name: %s , id: %d", user.getName(), newId);

        return user;
    }

    public User login(String name, String password){
        Check.notEmpty(name);
        Check.notEmpty(password);

        User user = dao.queryByName(name);

        if(user == null){
            throw new LoginException("user name not exist: " + name);
        }

        //
        if(user.getPassword().equals(password)){
            this.doLogin(user);
            return user;
        }
        else{
            throw new LoginException("wrong password.");
        }
    }

    private void doLogin(User user) {
        UserTool.login(user);
    }
}
