package me.dio.model;

import jakarta.persistence.Entity;

@Entity
public class GamesOnLibrary extends Games {

    private Integer playedTime;

    public Integer getPlayedTime() {
        return playedTime;
    }

    public void setPlayedTime(Integer playedTime) {
        this.playedTime = playedTime;
    }
}
