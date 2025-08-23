package com.clara.dslist.controllers;

import com.clara.dslist.dto.GameListDTO;
import com.clara.dslist.dto.GameMinDTO;
import com.clara.dslist.dto.ReplacementDTO;
import com.clara.dslist.services.GameListService;
import com.clara.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> searchByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.searchByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getTargetIndex());
    }
}
