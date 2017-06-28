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
				//Movie m = new Movie(title, runtime, year, plotSummary, genre);
				//System.out.printf("The database contains %s movies.\n", movieRepository.count());
				Movie m = new Movie("Title", "too long", 34, "things happened", Genre.HORROR);
				//System.out.println("movie title: " + m.getTitle());
				//movieRepository.save(m);
				//System.out.printf("The database contains %s movies.\n", movieRepository.count());
				//Movie m2 = new Movie("Title", "too long", 34, "things happened", Genre.HORROR);
				//movieRepository.save(m2);
				//System.out.printf("The database contains %s movies.\n", movieRepository.count());
				//List<Movie> movieList = movieRepository.findAll();
	            //for (Movie mRow : movieList) {
	            //    System.out.printf("%s) %s\n", mRow.getId(), mRow.getTitle());
	            //}
	//			http://localhost:8080/movie?title=%22title%22&runtime=%22tooLong%22&year=1995&plotSummary=%22pllot%22
				
//				User u1 = new User("john1", "pwd1", "this is john1 screenname", "mail.com");
//				userRepository.save(u1);
//				User u2 = new User("john2", "pwd2", "this is john2 screenname", "mail2.com");
//				userRepository.save(u2);
//				User u3 = new User("john3", "pwd3", "this is john3 screenname", "mail3.com");
//				userRepository.save(u3);
				List<User> userList = userRepository.findAll();
	            for (User userRow : userList) {
	                System.out.printf("%s) %s\n", userRow.getId(), userRow.getScreenname());
	            }
				model.addAttribute("movie", m);
				return "movie";
		}
}
