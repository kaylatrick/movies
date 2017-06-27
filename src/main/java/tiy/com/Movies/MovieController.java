package tiy.com.Movies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping('movie')
public class MovieController {
	@RequestMapping(path = "/movie", method = RequestMethod.GET)
	
	public String movie(Model model, String title, 
			String runtime, Integer year, String plotSummary, Genre genre) {
//			Movies m = new Movies(title, runtime, 34, plotSummary, genre);
			Movies m = new Movies("Title", "too long", 34, "things happened", Genre.HORROR);
			model.addAttribute("movie", m);
			return "movie";
	}

}
