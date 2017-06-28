package tiy.com.Movies;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {
	
	@RequestMapping(path = "/reviews", method = RequestMethod.GET) 
 	public String reviews(Model model, Integer movieID) { 
		
//		http://localhost:8080/role?fName=John&lName=Ulmer&birthday=Oct&bio=test	
		ArrayList<Review> reviews = new ArrayList<Review>();
		reviews.add(new Review(5,10,"awesome"));
		reviews.add(new Review(15,25,"lame"));
		reviews.add(new Review(5,17,"working?"));
		
// 		Role r = new Role("john", "ulmer", "oct", "string string string"); 
 		model.addAttribute("reviews", reviews); 
 		return "review"; 
 	} 

	
	

}
