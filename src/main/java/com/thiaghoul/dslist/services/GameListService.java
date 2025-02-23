package com.thiaghoul.dslist.services;

import com.thiaghoul.dslist.dto.GameDTO;
import com.thiaghoul.dslist.dto.GameListDTO;
import com.thiaghoul.dslist.dto.GameMinDTO;
import com.thiaghoul.dslist.entities.Game;
import com.thiaghoul.dslist.entities.GameList;
import com.thiaghoul.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameListRepository gameListRepository;

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

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
