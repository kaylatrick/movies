package tiy.com.Movies;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review implements Serializable {

	@Id
	@GeneratedValue
	int id;
	
	int movieID;
	int userID;
	String reviewText;
	
	public Review(int movieID, int userID, String reviewText) {
		this.movieID = movieID;
		this.userID = userID;
		this.reviewText = reviewText;
	}
	
	public int getMovieID() { 
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public int getId() {
		return id;
	}
// Helpful?
// Other users liking / rating the review


	
}
