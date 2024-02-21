package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entity.Songs;

public interface SongService {
	String addSongs(Songs songs);
	 boolean songExits(String songname);
	List<Songs> getSongs();
	public void updateSongs(Songs songs);
}
