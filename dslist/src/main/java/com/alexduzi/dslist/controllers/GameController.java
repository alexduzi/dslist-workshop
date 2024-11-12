package com.alexduzi.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexduzi.dslist.dto.GameDTO;
import com.alexduzi.dslist.dto.GameMinDTO;
import com.alexduzi.dslist.exceptions.NotFoundException;
import com.alexduzi.dslist.services.GameService;

@RestController
@RequestMapping(value = "${api.prefix}/games")
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("/{id}")
	public ResponseEntity<GameDTO> findById(@PathVariable Long id) {
		try {
			GameDTO result = gameService.findById(id);

			return ResponseEntity.ok(result);
		} catch (NotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping
	public ResponseEntity<List<GameMinDTO>> findAll() {
		List<GameMinDTO> games = gameService.findAll();

		return ResponseEntity.ok(games);
	}
}
