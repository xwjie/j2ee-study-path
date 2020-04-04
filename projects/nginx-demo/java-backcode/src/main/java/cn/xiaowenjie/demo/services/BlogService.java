package cn.xiaowenjie.demo.services;

import cn.xiaowenjie.demo.beans.Blog;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 晓风轻
 */
@Service
public class BlogService {

    private static final AtomicLong blogId = new AtomicLong(10000L);

    private static final ConcurrentHashMap<Long, Blog> blogs = new ConcurrentHashMap<>();

    public Collection<Blog> allBlog() {
        // 随机产生
        if (blogs.isEmpty()) {
            createTestData();
        }

        return blogs.values();
    }

    /**
     * 测试数据
     * @return
     */
//    private List<Blog> createTestData() {
//        return IntStream.range(100, 110).mapToObj(index -> new Blog(blogId.incrementAndGet(), "Title " + index, "Body " + index)).collect(Collectors.toList());
//    }

    /**
     * 测试数据
     *
     * @return
     */
    private void createTestData() {
        for (int i = 0; i < 5; i++) {
            Blog blog = new Blog(blogId.incrementAndGet(), "Title " + i, "Body " + i);
            blogs.put(blog.getId(), blog);
        }
    }

    public Blog getById(long id) {
        return blogs.get(id);
    }

    public void update(Blog blog) {
        blogs.put(blog.getId(), blog);
    }

    public long add(Blog blog) {
        long newId = blogId.incrementAndGet();

        blog.setId(newId);
        blogs.put(newId, blog);

        return newId;
    }
}
