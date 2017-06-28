package tiy.com.Movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping('movie')
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(path = "/movie", method = RequestMethod.GET)
		public String movie(Model model, String title, 
				String runtime, Integer year, String plotSummary, Genre genre) {
				Movie m = new Movie("Title", "too long", 34, "things happened", Genre.HORROR);
	//			http://localhost:8080/movie?title=%22title%22&runtime=%22tooLong%22&year=1995&plotSummary=%22pllot%22
				//DBReset rdb = new DBReset();
				//rdb.resetDB();
				model.addAttribute("movie", m);
				return "movie";
		}
	
	
	// delete DB file before running this
	@RequestMapping(path = "/resetDatabaseToTestStart", method = RequestMethod.GET)
	public String resetDatabaseToStart(Model model) {
			DBReset rdb = new DBReset();
			rdb.resetDB();
			return "reset";
	}
}
