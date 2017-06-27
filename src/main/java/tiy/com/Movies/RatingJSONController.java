package tiy.com.Movies;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingJSONController {
		
	@RequestMapping(path = "/rating.json", method = RequestMethod.GET)
	public Rating jsonRating(int numStars, String movie) {
		return new Rating(numStars, movie);
//		return new Movies("Title", "too long", 34, "things happened", Genre.HORROR);
//		http://localhost:8080/movie.json?title=Title&runtime=too%20long&year=34223423&plotSummary=thingshappened
		}
		
}
