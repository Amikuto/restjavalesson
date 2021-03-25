package uni.ex.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uni.ex.rest.model.Blog;
import uni.ex.rest.services.BlogServiceImpl;

import javax.validation.Valid;

@RestController
public class BlogController {

    @Autowired
    BlogServiceImpl blogService;

    @GetMapping("/blogs")
    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogService.getAll(pageable);
    }

    @PostMapping("/blogs")
    public Blog addBlog(@Valid @RequestBody Blog blog) {
        return blogService.save(blog);
    }

//    @PutMapping("/blogs")
//    public Blog updateBlog(@PathVariable)
}
