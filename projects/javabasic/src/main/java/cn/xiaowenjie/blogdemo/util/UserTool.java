package cn.xiaowenjie.blogdemo.util;

import cn.xiaowenjie.blogdemo.beans.User;
import cn.xiaowenjie.blogdemo.exceptions.LoginException;

public class UserTool {

    private final static  ThreadLocal<User> userThreadLocal = new ThreadLocal<User>(){
        @Override
        protected User initialValue() {
            return null;
        }
    };

    private UserTool(){

    }

    public static void login(User user){
        userThreadLocal.set(user);
    }

    public static User getLoginUser(){
        User user = userThreadLocal.get();

        if(user == null){
            throw new LoginException("not login");
        }

        return user;
    }

    public static User getLoginUserIfLogin(){
        return userThreadLocal.get();
    }

    public static long getLoginUserId() {
        return getLoginUser().getId();
    }
}
