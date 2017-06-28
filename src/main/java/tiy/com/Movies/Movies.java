package tiy.com.Movies;

import java.util.ArrayList;

public class Movies {

	int id;
	String title;
	String runtime;
	Integer year;
	String plotSummary;
	Genre genre;
	
	// handle as get methods for a particular movie
	//ArrayList<Quote> quotes;
	//ArrayList<Rating> ratings;
	//ArrayList<Review> reviews;
	//ArrayList<ActorDirectorWriter> actors;
	//ArrayList<ActorDirectorWriter> directors;
	//ArrayList<ActorDirectorWriter> writers;

	// lookup from external data
	//Showtimes
	// calculation based on ratings list
	//	Avg rating - operation on Ratings set

	public Movies(String title, String runtime, Integer year, String plotSummary, Genre genre) {
		super();
		this.title = title;
		this.runtime = runtime;
		this.year = year;
		this.plotSummary = plotSummary;
		this.genre = genre;
	}
	
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

}
