package com.clara.dslist.dto;


import com.clara.dslist.entities.Games;

//A classe GameMinDTO se trata de uma abstração do meu objeto principal, apenas com as informações que realmente quero utilizar/mostrar
//para meu cliente
public class GameMinDTO {
    private long id;
    private String title;
    private int year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {}

    public GameMinDTO(Games entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
