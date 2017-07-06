package tiy.com.Movies;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleJSONController implements Serializable{

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping(path = "/role/{movieId}/{roleId}", method = RequestMethod.PUT)
	public void addMovieRole(@PathVariable(required = true) int movieId,
			@PathVariable(required = true) int roleId) {
		Movie m = movieRepository.findOne(movieId);
		Role r = roleRepository.findOne(roleId);
		m.getRoles().add(r);
		r.getMovies().add(m);
		movieRepository.save(m);
		roleRepository.save(r);
	}

	@RequestMapping(path = "/role", method = RequestMethod.GET)
	public List<Role> jsonHome(String fName, String lName, String birthday,
			String bio) {
		// http://localhost:8080/role?fName=John&lName=Ulmer&birthday=Oct&bio=test
		List<Role> roleList = roleRepository.findPersonBySearch(fName, lName,
				birthday, bio);
		return roleList;
	}

	@RequestMapping(path = "/role/all", method = RequestMethod.GET)
	public List<Role> findAll() {
		// http://localhost:8080/role.json?fName=John&lName=Ulmer&birthday=Oct&bio=test
		List<Role> roleList = roleRepository.findAll();
		return roleList;
	}

	@RequestMapping(path = "/role/{id}", method = RequestMethod.GET)
	public Role getRole(@PathVariable int id) {
		Role role = roleRepository.getOne(id);
//		System.out.println(role);
		return role;
	}

	@RequestMapping(path = "/role", method = RequestMethod.POST)
	public Role insertRole(@RequestBody Role role) {
		// http://localhost:8080/role?fName=John&lName=Ulmer&birthday=Oct&bio=test
		Role r = new Role();
		// Role r = new Role("john", "ulmer", "oct", "string string string");
		// enter person
		r.setfName(role.getfName());
		r.setlName(role.getlName());
		r.setBirthday(role.getBirthday());
		r.setBio(role.getBio());
		roleRepository.save(r);
		return r;
	}

	@RequestMapping(path = "/role/{id}", method = RequestMethod.DELETE)
	public Role deleteRole(@PathVariable int id) {
		Role role = roleRepository.findOne(id);
		roleRepository.delete(role);
		System.out.println(role);
		return role;
	}

	// to test, go to postman > PUT > role/id > Body > "raw" radio button >
	// fields to update in {} & ""
	@RequestMapping(path = "/role/{id}", method = RequestMethod.PUT)
	public Role updateRole(@PathVariable int id, @RequestBody Role role) {
		Role roleRepo = roleRepository.findOne(id);

		if (role.getfName() != null) {
			roleRepo.setfName(role.getfName());
		}
		if (role.getlName() != null) {
			roleRepo.setlName(role.getlName());
		}
		if (role.getBirthday() != null) {
			roleRepo.setBirthday(role.getBirthday());
		}
		if (role.getBio() != null) {
			roleRepo.setBio(role.getBio());
		}

		roleRepository.save(roleRepo);
		return roleRepo;

	}

}
