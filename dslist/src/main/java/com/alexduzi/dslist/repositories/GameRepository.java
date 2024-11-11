package com.alexduzi.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexduzi.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
