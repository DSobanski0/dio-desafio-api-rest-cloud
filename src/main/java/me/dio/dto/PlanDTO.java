package me.dio.dto;

import me.dio.model.Plan;

public record PlanDTO(Long id, String name) {

    public PlanDTO(Plan model) {
        this(model.getId(), model.getName());
    }

    public Plan toModel() {
        Plan model = new Plan();
        model.setId(this.id);
        model.setName(this.name);
        return model;
    }
}
