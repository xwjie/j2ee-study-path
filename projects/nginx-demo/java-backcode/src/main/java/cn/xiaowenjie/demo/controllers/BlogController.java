package cn.xiaowenjie.demo.controllers;

import cn.xiaowenjie.demo.beans.Blog;
import cn.xiaowenjie.demo.beans.ResultBean;
import cn.xiaowenjie.demo.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * blog crud
 * @author 晓风轻
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public ResultBean<List<Blog>> list() {
        return new ResultBean<List<Blog>>(blogService.allBlog());
    }

    @GetMapping("/view")
    public ResultBean<Blog> view(long id) {
        return new ResultBean<Blog>(blogService.getById(id));
    }

    @PostMapping("/update")
    public ResultBean<Boolean> update(Blog blog) {
        System.out.println("update:" + blog);

        return new ResultBean<>(true);
    }

    @PostMapping("/delete")
    public ResultBean<Boolean> deleteBlog(long id) {
        System.out.println("delete:" + id);

        return new ResultBean<>(true);
    }
}
