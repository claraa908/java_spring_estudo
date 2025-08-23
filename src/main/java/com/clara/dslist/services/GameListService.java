package com.clara.dslist.services;

import com.clara.dslist.dto.GameListDTO;
import com.clara.dslist.entities.GameList;
import com.clara.dslist.projections.GameMinProjection;
import com.clara.dslist.repositories.GameListRepository;
import com.clara.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(GameListDTO::new).toList();
        return dto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int targetIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(targetIndex, obj);

        int min = Math.min(sourceIndex, targetIndex);
        int max = Math.max(sourceIndex, targetIndex);

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
