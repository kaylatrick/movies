package tiy.com.Movies;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="ROLE_ID")
	private int id;
	
	private String fName;
	private String lName;
	private String birthday;
	private String bio;	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//	@JoinColumn(table="movie", name="MOVIE_ID")
//	@JsonIgnore
//	@JsonManagedReference(value = "secondParent")
	private List<Movie> movies;


	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Role(String fName, String lName, String birthday, String bio) {
		this();
		this.fName = fName;
		this.lName = lName;
		this.birthday = birthday;
		this.bio = bio;
	}
	
	public Role(){
		this.movies = new ArrayList<Movie>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
