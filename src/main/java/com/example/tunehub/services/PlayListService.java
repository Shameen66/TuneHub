package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entity.PlayList;
import com.example.tunehub.entity.Songs;

public interface PlayListService {

	public void addplaylist(PlayList playlist);

	public List<PlayList> fetchplaylists();
	
}
