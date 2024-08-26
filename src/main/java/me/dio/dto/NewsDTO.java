package me.dio.dto;

import me.dio.model.News;

public record NewsDTO(String description) {

    public NewsDTO(News model) {
        this(model.getDescription());
    }

    public News toModel() {
        News model = new News();
        model.setDescription(this.description);
        return model;
    }
}
