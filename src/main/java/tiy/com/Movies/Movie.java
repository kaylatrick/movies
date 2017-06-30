package tiy.com.Movies;

import java.io.Serializable;


import java.util.List;
import java.util.Set;

import java.util.ArrayList;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name = "movie")
public class Movie implements Serializable{
	
	@Id
	@GeneratedValue
//	@Column(name="MOVIE_ID")
	int id;
//	@ManyToOne
//	ArrayList<Role> actorList;
//	@ManyToOne
//	ArrayList<Role> directorList;
//	@ManyToOne
//	ArrayList<Role> writerList;
	//@OneToMany(mappedBy="movie")
	//private List<Review> reviewList;

	String title;
	String runtime;
	Integer year;
	String plotSummary;
	Genre genre;

	// lookup from external data
	//Showtimes
	// calculation based on ratings list
	//	Avg rating - operation on Ratings set
	
	@ManyToMany(
			targetEntity=Role.class,
			cascade=CascadeType.ALL
			)
	@JoinTable(
			name="MOVIE_ROLE",
			joinColumns= @JoinColumn (table="movie", name="MOVIE_ID"),
			inverseJoinColumns=@JoinColumn(table="role", name="ROLE_ID")
			)
	private List<Role> roles;
	

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie() {
		
	}
	public Movie(int id) {
		this.id = id;
	}
	
	public Movie(String title, String runtime, Integer year, String plotSummary, Genre genre) {
		this.title = title;
		this.runtime = runtime;
		this.year = year;
		this.plotSummary = plotSummary;
		this.genre = genre;
	}
	public Movie(int id, String title, String runtime, Integer year, String plotSummary, Genre genre) {
		this.id = id;
		this.title = title;
		this.runtime = runtime;
		this.year = year;
		this.plotSummary = plotSummary;
		this.genre = genre;
	}
	

    @OneToMany(cascade=ALL, mappedBy="movie")
    public Set<Review> getReviews() { return reviews; }
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public int getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPlotSummary() {
		return plotSummary;
	}

	public void setPlotSummary(String plotSummary) {
		this.plotSummary = plotSummary;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
//	public List<Review> getReviewList() {
//		return reviewList;
//	}
}
