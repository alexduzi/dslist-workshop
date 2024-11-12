package com.alexduzi.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexduzi.dslist.dto.GameListDTO;
import com.alexduzi.dslist.dto.GameMinDTO;
import com.alexduzi.dslist.services.GameListService;
import com.alexduzi.dslist.services.GameService;

@RestController
@RequestMapping(value = "${api.prefix}/lists")
public class GameListController {

    @Autowired
	private GameListService gameListService;

    @Autowired
	private GameService gameService;

    @GetMapping
	public ResponseEntity<List<GameListDTO>> findAll() {
		List<GameListDTO> gameList = gameListService.findAll();

		return ResponseEntity.ok(gameList);
	}

    @GetMapping("/{listId}/games")
	public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
		List<GameMinDTO> gameList = gameService.findByList(listId);

		return ResponseEntity.ok(gameList);
	}
}
