package tiy.com.Movies;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 


public class Controller {
	
	@RequestMapping(path = "/role", method = RequestMethod.GET) 
 	public String person(Model model, String name, String city, int age) { 
 		Person p = new Person(name, city, age); 
 		model.addAttribute("person", p); 
 		return "person"; 
 	} 

	
	

}
