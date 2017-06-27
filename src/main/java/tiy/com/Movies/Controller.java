package tiy.com.Movies;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class Controller {
	
	@RequestMapping(path = "/role", method = RequestMethod.GET) 
 	public String role(Model model, String fName, String lName, String birthday,
			ArrayList<Movies> movies, String bio) { 
 		ActorDirectorWriter aDW = new ActorDirectorWriter(fName, lName, birthday, movies, bio); 
 		model.addAttribute("actordirectorwriter", aDW); 
 		return "actordirectorwriter"; 
 	} 

	
	

}
