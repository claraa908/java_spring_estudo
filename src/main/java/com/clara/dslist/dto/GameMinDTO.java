package com.clara.dslist.dto;


import com.clara.dslist.entities.Games;
import com.clara.dslist.projections.GameMinProjection;

//A classe GameMinDTO se trata de uma abstração do meu objeto principal, apenas com as informações que realmente quero utilizar/mostrar
//para meu cliente
public class GameMinDTO {
    private long id;
    private String title;
    private int gameYear;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {}

    public GameMinDTO(Games entity) {
        id = entity.getId();
        title = entity.getTitle();
        gameYear = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        gameYear = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getGameYear() {
        return gameYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
