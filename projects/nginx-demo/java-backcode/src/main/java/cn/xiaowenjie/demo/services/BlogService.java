package cn.xiaowenjie.demo.services;

import cn.xiaowenjie.demo.beans.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BlogService {

    private static final AtomicLong blogId = new AtomicLong(10000L);

    public List<Blog> allBLogs() {
       return IntStream.range(100, 110).mapToObj(index -> new Blog(blogId.incrementAndGet(), "Title " + index, "Body " + index)).collect(Collectors.toList());
    }

    public Blog getById(long id) {
        return new Blog(blogId.incrementAndGet(), "Title " + id, "Body " + id);
    }
}
