package me.dio.dto;

import me.dio.model.GamesOnLibrary;

import java.time.LocalTime;

public record GamesOnLibraryDTO(String name, Integer playedTime) {

    public GamesOnLibraryDTO(GamesOnLibrary model) {
        this(model.getName(), model.getPlayedTime());
    }

    public GamesOnLibrary toModel() {
        GamesOnLibrary model = new GamesOnLibrary();
        model.setName(this.name);
        model.setPlayedTime(this.playedTime);
        return model;
    }
}
