package tiy.com.Movies;

import tiy.com.Movies.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("select r from Role r where r.fName LIKE %?1%")
	List<Role> findPersonByNameLike(@Param("fName") String fName);
}
