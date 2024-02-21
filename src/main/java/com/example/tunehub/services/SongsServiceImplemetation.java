package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.Repository.SongsRepository;
import com.example.tunehub.entity.Songs;

@Service
public class SongsServiceImplemetation implements SongService{
	@Autowired
	SongsRepository srepo;

	@Override
	public String addSongs(Songs songs) {
		srepo.save(songs);
		return "Songs Added";
	}

	@Override
	public boolean songExits(String songname) {
		if (srepo.findBySongName(songname)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Songs> getSongs() {
		
		return srepo.findAll();
	}

	@Override
	public void updateSongs(Songs songs) {
		srepo.save(songs);
		
	}

	

	
	
	
}
