package com.example.tunehub.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Songs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String songName;
	String songArtist;
	String songGenre;
	String songLink;
	@Column(columnDefinition = "LONGTEXT")
    String imagedata;
	@ManyToMany
	List<PlayList> playlist;
	
	public Songs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Songs(int id, String songName, String songArtist, String songGenre, String songLink, String imagedata,
			List<PlayList> playlist) {
		super();
		this.id = id;
		this.songName = songName;
		this.songArtist = songArtist;
		this.songGenre = songGenre;
		this.songLink = songLink;
		this.imagedata = imagedata;
		this.playlist = playlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongArtist() {
		return songArtist;
	}

	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}

	public String getSongGenre() {
		return songGenre;
	}

	public void setSongGenre(String songGenre) {
		this.songGenre = songGenre;
	}

	public String getSongLink() {
		return songLink;
	}

	public void setSongLink(String songLink) {
		this.songLink = songLink;
	}

	public String getImagedata() {
		return imagedata;
	}

	public void setImagedata(String imagedata) {
		this.imagedata = imagedata;
	}

	public List<PlayList> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<PlayList> playlist) {
		this.playlist = playlist;
	}

	@Override
	public String toString() {
		return "Songs [id=" + id + ", songName=" + songName + ", songArtist=" + songArtist + ", songGenre="
				+ songGenre + ", songLink=" + songLink + ", imagedata=" + imagedata + "]";
	}
	
	
}
