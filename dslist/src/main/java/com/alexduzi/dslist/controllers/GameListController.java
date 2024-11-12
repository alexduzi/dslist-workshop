package com.alexduzi.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexduzi.dslist.dto.GameListDTO;
import com.alexduzi.dslist.services.GameListService;

@RestController
@RequestMapping(value = "${api.prefix}/lists")
public class GameListController {

    @Autowired
	private GameListService gameListService;

    @GetMapping
	public ResponseEntity<List<GameListDTO>> findAll() {
		List<GameListDTO> gameList = gameListService.findAll();

		return ResponseEntity.ok(gameList);
	}
}
