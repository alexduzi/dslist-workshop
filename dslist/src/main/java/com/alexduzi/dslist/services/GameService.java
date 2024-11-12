package com.alexduzi.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexduzi.dslist.dto.GameDTO;
import com.alexduzi.dslist.dto.GameMinDTO;
import com.alexduzi.dslist.entities.Game;
import com.alexduzi.dslist.exceptions.NotFoundException;
import com.alexduzi.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).orElseThrow(() -> new NotFoundException("Game not found at catalog!"));

		return new GameDTO(result);
    }
}
