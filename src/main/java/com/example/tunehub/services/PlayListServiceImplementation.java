package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.Repository.PlayListRepository;
import com.example.tunehub.entity.PlayList;

@Service
public class PlayListServiceImplementation implements PlayListService{
	@Autowired
	PlayListRepository Prepo;

	@Override
	public void addplaylist(PlayList playlist) {
		Prepo.save(playlist);
	}

	@Override
	public List<PlayList> fetchplaylists(int id) {
		return Prepo.findById(id);
	}

	@Override
	public List<PlayList> fetchplaylists() {
		return Prepo.findAll();
	}

	
}
