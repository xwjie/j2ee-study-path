package cn.xiaowenjie.mapdemo;

import cn.xiaowenjie.User;

import java.util.Collection;

public class UserControllerTest {

    public static void main(String[] args) {
        UserController userController = new UserController();

        User user = userController.createUser("xwj", 18);
        System.out.println("create user:" + user);

        Collection<User> users =  userController.queryAllUser();
        System.out.println("all user:" + users);

        boolean updateUser = userController.updateUser(user.getId(), "song", 38);
        System.out.println("update result:" + updateUser);

        users =  userController.queryAllUser();
        System.out.println("all user:" + users);

        User deleteUser = userController.deleteUser(user.getId());
        System.out.println("delete user:" + deleteUser);

        users =  userController.queryAllUser();
        System.out.println("all user:" +users);
    }
}
