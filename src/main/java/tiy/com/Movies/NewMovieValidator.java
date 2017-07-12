package tiy.com.Movies;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateNewMovieValidator")
public class NewMovieValidator implements Validator {
    
	@Override
    public boolean supports(Class<?> clazz) {
        return Movie.class.equals(clazz);
    }
    
    @Override
    public void validate(Object obj, Errors errors) {
        Movie movie = (Movie) obj;
        if (checkInputString(movie.getTitle())) {
            errors.rejectValue("title", "title-empty");
        }
    
        if (checkInputInt(movie.getYear())) {
            errors.rejectValue("year", "year-invalid");
        }
    }
 
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    
    private boolean checkInputInt(int input) {
        return (Integer.toString(input) == null || Integer.toString(input).length() != 4);
    }
}
