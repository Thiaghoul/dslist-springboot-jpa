package com.thiaghoul.dslist.services;

import com.thiaghoul.dslist.dto.GameDTO;
import com.thiaghoul.dslist.dto.GameListDTO;
import com.thiaghoul.dslist.dto.GameMinDTO;
import com.thiaghoul.dslist.entities.Game;
import com.thiaghoul.dslist.entities.GameList;
import com.thiaghoul.dslist.projections.GameMinProjection;
import com.thiaghoul.dslist.repositories.GameRepository;
import com.thiaghoul.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){

        List<Game> list = repository.findAll();
        List<GameMinDTO> gameMinDTOList = new ArrayList<>();

        for(Game game: list){
            GameMinDTO gameMinDTO = new GameMinDTO(game);
            gameMinDTOList.add(gameMinDTO);
        }

        return gameMinDTOList;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        List<GameMinDTO> gameMinDTOList = new ArrayList<>();

        for(GameMinProjection projection : list){
            GameMinDTO gameMinDTO = new GameMinDTO(projection);
            gameMinDTOList.add(gameMinDTO);
        }

        return gameMinDTOList;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Optional<Game> game = repository.findById(id);

        return game.map(GameDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

}
