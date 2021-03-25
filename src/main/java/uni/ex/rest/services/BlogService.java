package uni.ex.rest.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uni.ex.rest.model.Blog;

public interface BlogService {


    Blog save(Blog blog);

    ResponseEntity<?> delete(Long id);

    Blog update(Long id, Blog blog);

    Blog getBlogById(Long id);

    Page<Blog> getAll(Pageable pageable);

}
