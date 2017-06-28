package tiy.com.Movies;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController; 



@RestController
public class MovieJSONController {
	@Autowired
	private MovieRepository movieRepository;
	
	@RequestMapping(path = "/movie.json", method = RequestMethod.GET)
	public Movie jsonMovie(String title, String runtime, 
			Integer year, String plotSummary, Genre genre) {
		Movie m = movieRepository.getOne(1);
		System.out.println(m.getTitle());
		return m;
		//return new Movie("Title", "too long", 34, "things happened", Genre.HORROR);
//		http://localhost:8080/movie.json?title=Title&runtime=too%20long&year=34223423&plotSummary=thingshappened
	}
}
