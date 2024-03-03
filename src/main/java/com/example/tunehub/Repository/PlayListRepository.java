package com.example.tunehub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entity.PlayList;
import java.util.List;

public interface PlayListRepository extends JpaRepository<PlayList, Integer> {
    List<PlayList> findById(int id);
}
