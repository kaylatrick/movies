package tiy.com.Movies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {
	
	@RequestMapping(path = "/role", method = RequestMethod.GET) 
 	public String role(Model model, String fName, String lName, String birthday, String bio) { 
 		Role r = new Role("john", "ulmer", "oct", "string string string"); 
 		model.addAttribute("role", r); 
 		return "role"; 
 	} 

	
	

}
