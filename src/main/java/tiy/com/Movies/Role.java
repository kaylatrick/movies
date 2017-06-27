package tiy.com.Movies;

import java.util.ArrayList;

public class Role {

	private String fName;
	private String lName;
	private String birthday;
	private ArrayList<Movies> movies;
	private String bio;	
	
	public Role(String fName, String lName, String birthday,
			ArrayList<Movies> movies, String bio) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.birthday = birthday;
		this.movies = movies;
		this.bio = bio;
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
	public ArrayList<Movies> getMovies() {
		return movies;
	}
	public void setMovies(ArrayList<Movies> movies) {
		this.movies = movies;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
