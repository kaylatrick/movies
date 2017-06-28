package tiy.com.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(path = "/role", method = RequestMethod.GET) 
 	public String role(Model model, String fName, String lName, String birthday, String bio) { 
//		http://localhost:8080/role?fName=John&lName=Ulmer&birthday=Oct&bio=test		
 		Role r = new Role(fName, lName, birthday, bio); 
// 		Role r = new Role("john", "ulmer", "oct", "string string string"); 
 		model.addAttribute("role", r); 
 		r.setfName(fName);
 		r.setlName(lName);
 		r.setBirthday(birthday);
 		r.setBio(bio);
 		roleRepository.save(r);
 		return "role";
 		
 		
 	} 

	
	

}
