package com.alexduzi.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexduzi.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
