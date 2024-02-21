package com.example.tunehub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entity.Songs;

public interface SongsRepository extends JpaRepository<Songs, Integer>{

	Songs findBySongName(String songname);

}
