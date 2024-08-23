package me.dio.service;

import me.dio.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> findAll();
    Player findById(Long id);
    Player create(Player entity);
    Player update(Long id, Player entity);
    void delete(Long id);
}
