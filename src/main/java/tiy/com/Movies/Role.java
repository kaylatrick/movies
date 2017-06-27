package tiy.com.Movies;

import java.util.ArrayList;

public class Role {

	private String fName;
	private String lName;
	private String birthday;
	private String bio;	
	
	public Role(String fName, String lName, String birthday, String bio) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.birthday = birthday;
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
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
