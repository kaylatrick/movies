package tiy.com.Movies;
 
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestController
@Api(value="Movies", description="JSON operations pertaining to IMDBClone movies")
//@EnableWebMvc
public class MovieJSONController {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NewMovieValidator newMovieValidator;
	
//	@Autowired
//	private RestResponseEntityExceptionHandler restResponse;
	
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * Given a movie ID (int), return that movie from the database.
	 *
	 * @param id An int that is a valid ID for a movie.
	 * @return   m (movie object) with title, runtime, year, genre, and plot summary.
	 * @see      Movie
	 */
	@ApiOperation(value = "Returns a movie based on ID")
	@RequestMapping(path = "/api/movie/{id}", method = RequestMethod.GET)
	public Movie jsonMovie(@PathVariable Integer id) {	
		Movie m = movieRepository.getOne(id);
		
		return m;
	}
	
	/**
	 * Given a movie ID (int), delete that movie from the database.
	 *
	 * @param id An int that is a valid ID for a movie.
	 * @return   m (the movie object that has been deleted) with title, runtime, year, genre, and plot summary.
	 * @see      Movie
	 */
	@ApiOperation(value = "Deletes a movie based on ID")
	@RequestMapping(path = "/api/movie/{id}", method = RequestMethod.DELETE)
	public Movie deleteMovie(@PathVariable Integer id) {	
		Movie m = movieRepository.getOne(id);
		movieRepository.delete(m);
		return m;
	}
	
	/**
	 * Accepts a JSON Movie object with title, runtime, year, genre set, 
	 * returns JSON Movie object with auto-generated ID.
	 *
	 * @param addingMovie A movie object with values for title, runtime, year, and genre.
	 * @return 
	 * @return            returnedMovie with ID set
	 * @see               Movie
	 */
	@ApiOperation(value = "Adds a new movie")
	@RequestMapping(path = "/api/movie/", method = RequestMethod.POST)
	public Exception addMovie(@RequestBody @Valid Movie addingMovie, BindingResult result) throws Exception {
		newMovieValidator.validate(addingMovie, result);
		if (result.hasErrors()) {
			logger.info("Title: '" + addingMovie.getTitle() + "' or Year: '" + "' is not valid.");
			Exception m = new Exception();
			return m;
		} else {
			logger.info("Title: '" + addingMovie.getTitle() + "' was added with id: '" + addingMovie.getId() + "' and Year: '" + addingMovie.getYear() + "'.");
			movieRepository.save(addingMovie);
			return null; }
	}
	
	/**
	 * Accepts a JSON Movie object with title, runtime, year, genre set, 
	 * returns a JSON Movie object showing the updated values.
	 *
	 * @param updatingMovie A movie object with values for ID & optionally for title, runtime, year, and genre.
	 * @return              returnedMovie with ID set
	 * @see                 Movie
	 */
	@ApiOperation(value = "Updates a movie's title, runtime, genre, year, and / or plot summary based on ID")
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
	
	/**
	 * Accepts a String that will be used to search movie titles and return a set of matching results
	 *
	 * @param title A String used to search for matching titles.
	 * @return      movieList - a list of matching movies.
	 * @see         Movie
	 */
	@ApiOperation(value = "Search for a movie based on title")
	@RequestMapping(path = "/findMovies", method = RequestMethod.GET)
	public List<Movie> movieSearch(String title, Genre genre) {
		// http://localhost:8080/findMovies?title=yes
		// http://localhost:8080/findMovies?title=t
		List<Movie> movieList = movieRepository.findMovieBySearch(title);
		return movieList;
	}

	/**
	 * Return a list of movies in the DB.
	 *
	 * @return      movieList - a list of all movies.
	 * @see         Movie
	 */
	// get a list of all movies
	@ApiOperation(value = "Returns a list of all available movies")
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
