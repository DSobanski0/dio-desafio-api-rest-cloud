package me.dio.dto;

import me.dio.model.Plan;

public record PlanDTO(String name) {

    public PlanDTO(Plan model) {
        this(model.getName());
    }

    public Plan toModel() {
        Plan model = new Plan();
        model.setName(this.name);
        return model;
    }
}
