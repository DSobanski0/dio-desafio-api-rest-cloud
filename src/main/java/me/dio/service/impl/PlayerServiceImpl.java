package me.dio.service.impl;

import me.dio.model.Player;
import me.dio.repository.PlayerRepository;
import me.dio.service.PlayerService;
import me.dio.service.exception.BusinessException;
import me.dio.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Player findById(Long id) {
        return this.playerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Player create(Player playerToCreate) {
        ofNullable(playerToCreate).orElseThrow(() -> new BusinessException("Player to create must not be null."));
        ofNullable(playerToCreate.getPlan()).orElseThrow(() -> new BusinessException("Player plan must not be null."));
        ofNullable(playerToCreate.getGamesOnStore()).orElseThrow(() -> new BusinessException("Player games on store must not be null."));

        if (playerToCreate.getId() != null && playerRepository.existsById(playerToCreate.getId())) {
            throw new BusinessException("This id number already exists.");
        }
        return this.playerRepository.save(playerToCreate);
    }

    @Transactional
    public Player update(Long id, Player playerToUpdate) {
        Player dbPlayer = this.findById(id);
        if (playerToUpdate.getId() != null && !dbPlayer.getId().equals(playerToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbPlayer.setName(playerToUpdate.getName());
        dbPlayer.setGamesOnStore(playerToUpdate.getGamesOnStore());
        dbPlayer.setGamesOnLibrary(playerToUpdate.getGamesOnLibrary());
        dbPlayer.setPlan(playerToUpdate.getPlan());
        dbPlayer.setNews(playerToUpdate.getNews());

        return this.playerRepository.save(dbPlayer);
    }

    @Transactional
    public void delete(Long id) {
        Player dbPlayer = this.findById(id);
        this.playerRepository.delete(dbPlayer);
    }
}
