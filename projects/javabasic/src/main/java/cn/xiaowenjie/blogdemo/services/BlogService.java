package cn.xiaowenjie.blogdemo.services;

import cn.xiaowenjie.blogdemo.beans.Blog;
import cn.xiaowenjie.blogdemo.daos.BlogDao;
import cn.xiaowenjie.blogdemo.util.Check;
import cn.xiaowenjie.blogdemo.util.UserTool;
import cn.xiaowenjie.mapdemo.UserControllerTest;

import java.util.Collection;

public class BlogService {

    private final static BlogService instance = new BlogService();

    private BlogService() {

    }

    public static BlogService getInstance() {
        return instance;
    }

    //
    private final BlogDao dao = BlogDao.getInstance();

    public long addBlog(Blog blog) {

        Check.notNull(blog);
        Check.notEmpty(blog.getTitle());
        Check.notEmpty(blog.getBody());

        //
        blog.setCreator(UserTool.getLoginUserId());

        long newId = dao.addBlog(blog);

        System.out.printf("add blog id: %d\n", newId);

        return newId;
    }

    public Collection<Blog> queryAll() {
        return dao.queryAll();
    }

    public Blog getByID(long id) {
        Check.check(id > 0L, "id {} illeage", id);
        return dao.getByID(id);
    }

    public Blog delete(long id) {
        Check.check(id > 0L, "id {} illeage", id);

        Blog blog = dao.getByID(id);

        // 这里可以抛异常当做失败，也可以直接返回null
        if (blog == null) {
            return null;
        }

        Check.check(blog.getCreator() == UserTool.getLoginUserId(), "it is not your blog");

        System.out.printf("delete blog id: %d\n", id);

        return dao.delete(id);
    }
}
