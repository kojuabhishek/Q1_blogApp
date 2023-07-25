package koju.abhishek.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import koju.abhishek.springboot.model.User;
import koju.abhishek.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
