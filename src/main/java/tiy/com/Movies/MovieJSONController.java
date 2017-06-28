package tiy.com.Movies;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class MovieJSONController {
	@RequestMapping(path = "/movie.json", method = RequestMethod.GET)
	public Movie jsonMovie(String title, String runtime, 
			Integer year, String plotSummary, Genre genre) {
		return new Movie(title, runtime, year, plotSummary, genre);
//		return new Movies("Title", "too long", 34, "things happened", Genre.HORROR);
//		http://localhost:8080/movie.json?title=Title&runtime=too%20long&year=34223423&plotSummary=thingshappened
	}
}
