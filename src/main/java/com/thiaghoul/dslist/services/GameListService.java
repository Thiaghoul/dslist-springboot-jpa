package com.thiaghoul.dslist.services;

import com.thiaghoul.dslist.dto.GameDTO;
import com.thiaghoul.dslist.dto.GameListDTO;
import com.thiaghoul.dslist.dto.GameMinDTO;
import com.thiaghoul.dslist.entities.Game;
import com.thiaghoul.dslist.entities.GameList;
import com.thiaghoul.dslist.repositories.GameListRepository;
import com.thiaghoul.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){

        List<GameList> list = repository.findAll();
        List<GameListDTO> gameListDTOList = new ArrayList<>();

        for(GameList gameList: list){
            GameListDTO gameListDTO = new GameListDTO(gameList);
            gameListDTOList.add(gameListDTO);
        }

        return gameListDTOList;
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameListDTO gameListDTO = new GameListDTO(repository.findById(id).get());
        return gameListDTO;
    }
}
