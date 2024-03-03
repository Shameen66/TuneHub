package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entity.PlayList;

public interface PlayListService {

	public void addplaylist(PlayList playlist);

	public List<PlayList> fetchplaylists(int id);

	public List<PlayList> fetchplaylists();
	
}
