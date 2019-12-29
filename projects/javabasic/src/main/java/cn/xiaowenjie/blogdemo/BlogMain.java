package cn.xiaowenjie.blogdemo;

import cn.xiaowenjie.blogdemo.beans.Blog;
import cn.xiaowenjie.blogdemo.beans.User;
import cn.xiaowenjie.blogdemo.services.BlogService;
import cn.xiaowenjie.blogdemo.services.UserService;

import java.util.Collection;

public class BlogMain {
    public static void main(String[] args) {
        User user = new User();

        user.setName("xiao");
        user.setPassword("123456");

        UserService userService = UserService.getInstance();

        System.out.println("create user");
        User user1 = userService.addUser(user);

        System.out.println("\nlogin");
        userService.login("xiao", "123456");


        Blog blog = new Blog();

        blog.setTitle("title is here");
        blog.setBody("blog body");

        BlogService blogService = BlogService.getInstance();

        System.out.println("create blog");
        long blogId = blogService.addBlog(blog);

        System.out.printf("\ncreate blog %d\n", blogId);

        System.out.println("query blog by id");
        Blog blog1 = blogService.getByID(blogId);
        System.out.println(blog1);

        System.out.println("query All blogs");
        Collection<Blog> blogs = blogService.queryAll();
        System.out.println(blogs);

        System.out.println("delete blog by id");
        Blog blog2 = blogService.delete(blogId);
        System.out.println(blog2);
    }
}
