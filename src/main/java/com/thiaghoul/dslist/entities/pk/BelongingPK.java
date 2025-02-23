package com.thiaghoul.dslist.entities.pk;

import com.thiaghoul.dslist.entities.Belonging;
import com.thiaghoul.dslist.entities.Game;
import com.thiaghoul.dslist.entities.GameList;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public BelongingPK(){

    }

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPK that = (BelongingPK) o;
        return Objects.equals(game, that.game) && Objects.equals(gameList, that.gameList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, gameList);
    }
}
