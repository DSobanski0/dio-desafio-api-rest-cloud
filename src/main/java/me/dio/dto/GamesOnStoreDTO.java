package me.dio.dto;

import me.dio.model.GamesOnStore;

public record GamesOnStoreDTO(String name, Double price) {

    public GamesOnStoreDTO(GamesOnStore model) {
        this(model.getName(), model.getPrice());
    }

    public GamesOnStore toModel() {
        GamesOnStore model = new GamesOnStore();
        model.setName(this.name);
        model.setPrice(this.price);
        return model;
    }
}
