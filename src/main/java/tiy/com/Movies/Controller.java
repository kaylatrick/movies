package tiy.com.Movies;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controller {
	
	@RequestMapping(path = "/role", method = RequestMethod.GET) 
 	public String role(Model model, String fName, String lName, String birthday,
			ArrayList<Movies> movies, String bio) { 
 		//ActorDirectorWriter aDW = new ActorDirectorWriter(fname, lName, birthday, movies, bio); 
 		Role role = new Role("john", "ulmer", "oct", null, "string string string"); 
 		model.addAttribute("role", role); 
 		return "role"; 
 	} 

	
	

}
