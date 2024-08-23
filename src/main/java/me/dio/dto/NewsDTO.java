package me.dio.dto;

import me.dio.model.News;

public record NewsDTO(Long id, String description) {

    public NewsDTO(News model) {
        this(model.getId(), model.getDescription());
    }

    public News toModel() {
        News model = new News();
        model.setId(this.id);
        model.setDescription(this.description);
        return model;
    }
}
