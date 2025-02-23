package com.thiaghoul.dslist.dto;

import com.thiaghoul.dslist.entities.Game;
import com.thiaghoul.dslist.projections.GameMinProjection;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class GameMinDTO {

    private Long id;

    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){

    }

    public GameMinDTO(Game game) {
        this.shortDescription = game.getShortDescription();
        this.imgUrl = game.getImgUrl();
        this.year = game.getYear();
        this.title = game.getTitle();
        this.id = game.getId();
    }

    public GameMinDTO(GameMinProjection projection){
        this.shortDescription = projection.getShortDescription();
        this.imgUrl = projection.getImgUrl();
        this.year = projection.getYear();
        this.title = projection.getTitle();
        this.id = projection.getId();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameMinDTO that = (GameMinDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
