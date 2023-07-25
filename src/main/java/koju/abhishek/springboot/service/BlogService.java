package koju.abhishek.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import koju.abhishek.springboot.model.Blog;
import koju.abhishek.springboot.repository.BlogRepo;




@Service
public class BlogService {
	
	@Autowired
	private BlogRepo repo;
	
	public void addEmp(Blog e) 
	{
		repo.save(e);
	}
	
	public List<Blog> getAllEmp()
	{
		return repo.findAll();
	}
	
	public Blog getEmpById(int id)
	{
		Optional<Blog>  e=repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id)
	{
		repo.deleteById(id);
	}

}
