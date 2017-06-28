package tiy.com.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleJSONController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(path = "/role.json", method = RequestMethod.GET)
	public Role jsonHome(String fName, String lName, String birthday, String bio) {	
// http://localhost:8080/role.json?fName=John&lName=Ulmer&birthday=Oct&bio=test	
		Role r = new Role(fName, lName, birthday, bio);
		return r; 

	}
}
