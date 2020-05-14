package application;

import java.util.Iterator;

//import java.io.File;

public class User {

	private String username, password, pic;
	private Iterator<String> favs;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() {
		username = password = "";
	}
	
	public User(String u, String p, String i) {
		username = u ;
		password = p;
		pic = i;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Iterator<String> getFavs() {
		return favs;
	}

	public void setFavs(Iterator<String> favs) {
		this.favs = favs;
	}
}
