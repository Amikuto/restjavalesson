package uni.ex.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.ex.rest.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
