package me.dio.dto;

import me.dio.model.*;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record PlayerDTO (
        String name,
        List<GamesOnLibraryDTO> gamesOnLibrary,
        List<GamesOnStoreDTO> gamesOnStore,
        List<NewsDTO> news,
        PlanDTO plan) {

    public PlayerDTO(Player model) {
        this(
                model.getName(),
                ofNullable(model.getGamesOnLibrary()).orElse(emptyList()).stream().map(GamesOnLibraryDTO::new).collect(toList()),
                ofNullable(model.getGamesOnStore()).orElse(emptyList()).stream().map(GamesOnStoreDTO::new).collect(toList()),
                ofNullable(model.getNews()).orElse(emptyList()).stream().map(NewsDTO::new).collect(toList()),
                ofNullable(model.getPlan()).map(PlanDTO::new).orElse(null)
        );
    }

    public Player toModel() {
        Player model = new Player();
        model.setName(this.name);
        model.setGamesOnLibrary(ofNullable(this.gamesOnLibrary).orElse(emptyList()).stream().map(GamesOnLibraryDTO::toModel).collect(toList()));
        model.setGamesOnStore(ofNullable(this.gamesOnStore).orElse(emptyList()).stream().map(GamesOnStoreDTO::toModel).collect(toList()));
        model.setNews(ofNullable(this.news).orElse(emptyList()).stream().map(NewsDTO::toModel).collect(toList()));
        model.setPlan(ofNullable(this.plan).map(PlanDTO::toModel).orElse(null));
        return model;
    }
}
