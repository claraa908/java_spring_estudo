package com.clara.dslist.services;

import com.clara.dslist.dto.GameListDTO;
import com.clara.dslist.entities.GameList;
import com.clara.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(GameListDTO::new).toList();
        return dto;
    }
}
