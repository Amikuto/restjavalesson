package uni.ex.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uni.ex.rest.exceptions.ResourceNotFoundException;
import uni.ex.rest.model.Blog;
import uni.ex.rest.repository.BlogRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogService blogService;

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow();
        blogRepository.delete(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Blog update(Long id, Blog blog) {
        return blogRepository.findById(id)
                .map(blog_temp -> {
                    blog_temp.setAuthor(blog.getAuthor());
                    blog_temp.setName(blog.getName());
                    blog_temp.setTag(blog.getTag());
                    blog_temp.setText(blog.getText());
                    return blogRepository.save(blog_temp);
                }).orElseThrow();
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElseThrow();
    }

    @Override
    public Page<Blog> getAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }
}
