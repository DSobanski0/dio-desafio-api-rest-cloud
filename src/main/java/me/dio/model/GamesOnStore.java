package me.dio.model;

import jakarta.persistence.Entity;

@Entity
public class GamesOnStore extends Games {

    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
