package com.example.tunehub.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class PlayList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String playListName;
	@ManyToMany
	List<Songs> song;
	
	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayList(int id, String playListName, List<Songs> song) {
		super();
		this.id = id;
		this.playListName = playListName;
		this.song = song;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public List<Songs> getSong() {
		return song;
	}

	public void setSong(List<Songs> song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "PlayList [id=" + id + ", playListName=" + playListName + ", song=" + song + "]";
	}
	
	
}
