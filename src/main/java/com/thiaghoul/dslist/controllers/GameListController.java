package com.thiaghoul.dslist.controllers;

import com.thiaghoul.dslist.dto.GameDTO;
import com.thiaghoul.dslist.dto.GameListDTO;
import com.thiaghoul.dslist.dto.GameMinDTO;
import com.thiaghoul.dslist.dto.ReplacementDTO;
import com.thiaghoul.dslist.services.GameListService;
import com.thiaghoul.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO replacement){
        service.move(listId, replacement.getSourceIndex(), replacement.getDestinationIndex());
    }

}
