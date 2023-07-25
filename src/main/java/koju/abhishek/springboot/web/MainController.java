package koju.abhishek.springboot.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import koju.abhishek.springboot.model.Blog;
import koju.abhishek.springboot.service.BlogService;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@Autowired
	private BlogService service;
	
	
	@GetMapping("/employee")
	public String home(Model m) {
		
		List<Blog> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		
		
		return "index_blog";
	}
	
	@GetMapping("/addemp")
	public String addEmpform()
	{
		return "add_blog";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Blog e, HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
		
		session.setAttribute("msg", "Blog Added.....");
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m)
	{
		
		Blog e = service.getEmpById(id);
		
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Blog e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg","Edited hello ...");
		return "redirect:/";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg","Removed.....");
		return "redirect:/";
	}
}
