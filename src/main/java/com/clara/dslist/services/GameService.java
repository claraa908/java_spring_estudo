package com.clara.dslist.services;

import com.clara.dslist.dto.GameDTO;
import com.clara.dslist.dto.GameMinDTO;
import com.clara.dslist.entities.Games;
import com.clara.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//É registrado como service mas também pode ser registrado como Component
//Aqui será realizado as regras de negócio, ou seja, qualquer busca, atualização, inserção ou remoção
//seguirá critérios de segurança estabelecidos aqui, utilizando os comandos da camada de acesso a dados(repositorio)
@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Games result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Games> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(GameMinDTO::new).toList();
        return  dto;
    }
}
