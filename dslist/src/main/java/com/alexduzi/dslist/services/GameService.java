package com.alexduzi.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexduzi.dslist.dto.GameMinDTO;
import com.alexduzi.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {
		return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
	}

}
