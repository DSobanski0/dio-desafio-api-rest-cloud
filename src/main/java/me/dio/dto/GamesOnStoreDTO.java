package me.dio.dto;

import me.dio.model.GamesOnStore;

public record GamesOnStoreDTO(Long id, String name, Double price) {

    public GamesOnStoreDTO(GamesOnStore model) {
        this(model.getId(), model.getName(), model.getPrice());
    }

    public GamesOnStore toModel() {
        GamesOnStore model = new GamesOnStore();
        model.setId(this.id);
        model.setName(this.name);
        model.setPrice(this.price);
        return model;
    }
}
