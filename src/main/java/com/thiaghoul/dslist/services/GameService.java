package com.thiaghoul.dslist.services;

import com.thiaghoul.dslist.dto.GameMinDTO;
import com.thiaghoul.dslist.entities.Game;
import com.thiaghoul.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){

        List<Game> list = repository.findAll();
        List<GameMinDTO> gameMinDTOList = new ArrayList<>();

        for(Game game: list){
            GameMinDTO gameDTO = new GameMinDTO(game);
            gameMinDTOList.add(gameDTO);
        }

        return gameMinDTOList;
    }

}
