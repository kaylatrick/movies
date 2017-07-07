package tiy.com.Movies;
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc; 

@RestController
//@EnableWebMvc
public class UserJSONController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	
	// return a user for a specific ID
	@RequestMapping(path = "/api/user/{id}", method = RequestMethod.GET)
	public User userByID(@PathVariable Integer id) {	
		User u = userRepository.getOne(id);
		return u;
	}
	
	// delete a user for a specific ID
	@RequestMapping(path = "/api/user/{id}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable Integer id) {	
		User u = userRepository.getOne(id);
		userRepository.delete(u);
		return u;
	}
	
	// add a new user
	@RequestMapping(path = "/api/user/", method = RequestMethod.POST)
	public User addUser(@RequestBody User addingUser) {
		User returnedUser = userRepository.save(addingUser);
		return returnedUser;
	}
	
	//update a user
	@RequestMapping(path = "/api/user/{id}", method = RequestMethod.PUT)
	public User updateUser(@PathVariable Integer id,
			@RequestBody User updatingUser) {
		User u = userRepository.getOne(id);
		if (updatingUser.getUsername() != null) {
			u.setUsername(updatingUser.getUsername());
		}
		if (updatingUser.getPassword() != null) {
			u.setPassword(updatingUser.getPassword());
		}
		if (updatingUser.getScreenname() != null) {
			u.setScreenname(updatingUser.getScreenname());
		}
		if (updatingUser.getEmail() != null) {
			u.setEmail(updatingUser.getEmail());
		}
		userRepository.save(u);
		return u;
	}
	
//	@RequestMapping(path = "/findMovies", method = RequestMethod.GET)
//	public List<Movie> movieSearch(String title, Genre genre) {
//		// http://localhost:8080/findMovies?title=yes
//		// http://localhost:8080/findMovies?title=t
//		List<Movie> movieList = movieRepository.findMovieBySearch(title);
//		return movieList;
//	}

	// get a list of all users
	@RequestMapping(path = "/api/getAllUsers", method = RequestMethod.GET)
	public List<User> jsonAllMovies() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
}
