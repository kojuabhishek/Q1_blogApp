package koju.abhishek.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import koju.abhishek.springboot.model.Blog;



@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer>{

}
