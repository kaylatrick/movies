package tiy.com.Movies;
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class MovieJSONController {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	// return a movie for a specific ID
	@RequestMapping(path = "/api/movie/{id}", method = RequestMethod.GET)
	public Movie jsonMovie(@PathVariable Integer id) {	
		Movie m = movieRepository.getOne(id);
		return m;
	}
	
	// delete a movie for a specific ID
	@RequestMapping(path = "/api/movie/{id}", method = RequestMethod.DELETE)
	public Movie deleteMovie(@PathVariable Integer id) {	
		Movie m = movieRepository.getOne(id);
		movieRepository.delete(m);
		return m;
	}
	
	// add a new movie
	@RequestMapping(path = "/api/movie/", method = RequestMethod.POST)
	public Movie addMovie(@RequestBody Movie addingMovie) {
		Movie returnedMovie = movieRepository.save(addingMovie);
		return returnedMovie;
	}
	
	//update a movie
	@RequestMapping(path = "/api/movie/{id}", method = RequestMethod.PUT)
	public Movie updateMovie(@PathVariable Integer id,
			@RequestBody Movie updatingMovie) {
		Movie m = movieRepository.getOne(id);
		if (updatingMovie.getTitle() != null) {
			m.setTitle(updatingMovie.getTitle());
		}
		if (updatingMovie.getRuntime() != null) {
			m.setRuntime(updatingMovie.getRuntime());
		}
		if (updatingMovie.getYear() != 0) {
			m.setYear(updatingMovie.getYear());
		}
		if (updatingMovie.getPlotSummary() != null) {
			m.setPlotSummary(updatingMovie.getPlotSummary());
		}
		if (!(updatingMovie.getGenre().equals(Genre.DONOTUPDATE))) {
			m.setGenre(updatingMovie.getGenre());
		}
		movieRepository.save(m);
		return m;
	}
	
	//get a list of all reviews for a movie
	@RequestMapping(path = "/api/getAllReviewsForMovie", method = RequestMethod.GET)
	public List<Review> jsonAllReviews() {
		List<Review> reviewList = new ArrayList<Review>();
		reviewList = reviewRepository.findAll();
		Movie m = movieRepository.getOne(3);
		//reviewList = reviewRepository.findAll(Movie m);
		return reviewList;
	}
	
	//find a list of movies based on querystring parameters
	@RequestMapping(path = "/api/movie", method = RequestMethod.GET)
	public List<Movie> findMovie(@RequestParam String title,
			@RequestParam Integer year,
			@RequestParam Genre genre) {
		List<Movie> searchResults = new ArrayList<Movie>();
		
		if (title != null) {
			//m.setTitle(updatingMovie.getTitle());
		}
		if (year != null) {
			//m.setYear(updatingMovie.getYear());
		}
		if (genre != null) {
			//m.setGenre(updatingMovie.getGenre());
		}
		return searchResults;		
	}

	// get a list of all movies
	@RequestMapping(path = "/api/getAllMovies", method = RequestMethod.GET)
	public List<Movie> jsonAllMovies() {
		List<Movie> movieList = movieRepository.findAll();
		return movieList;
	}
	

	
//	@RequestMapping(path = "/api/user/login/{username}/{password}", method = RequestMethod.GET)
//	public UsernamePasswordAuthenticationToken userLogin(@PathVariable String username, @PathVariable String password) {
////		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////		return auth;
//		UsernamePasswordAuthenticationToken authRequest = new 
//				UsernamePasswordAuthenticationToken(username, password);
//		SecurityContextHolder.getContext().setAuthentication(authRequest);
//		return authRequest;
//	}
}
