package net.pingworks.example.musicDB.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AlbumDTO {

	private long id;

	private String artist;

	private String title;

	public String getArtist() {
		return artist;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		String string = "Artist: " + artist + ", Title: " + title;
		return string;
	}

}
