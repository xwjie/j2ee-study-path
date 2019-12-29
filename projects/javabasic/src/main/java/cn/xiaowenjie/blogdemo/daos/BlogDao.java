package cn.xiaowenjie.blogdemo.daos;

import cn.xiaowenjie.blogdemo.beans.Blog;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class BlogDao {

    private final static  BlogDao instance = new BlogDao();

    private final static Map<Long, Blog> blogs = new TreeMap<>();

    private final static AtomicLong idSeq = new AtomicLong(100L);

    private BlogDao(){

    }

    public static BlogDao getInstance() {
        return instance;
    }

    public long addBlog(Blog blog){
        long newId = idSeq.getAndIncrement();

        blog.setId(newId);

        blogs.put(newId, blog);
        return newId;
    }

    public Collection<Blog> queryAll(){
        return blogs.values();
    }

    public Blog getByID(long id){
        return blogs.get(id);
    }

    public Blog delete(long id){
        return blogs.remove(id);
    }
}
