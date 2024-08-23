package me.dio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.dto.PlayerDTO;
import me.dio.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
@Tag(name = "Players Controller", description = "RESTful API for managing players.")
public record PlayerController(PlayerService playerService) {
    
    @GetMapping
    @Operation(summary = "Get all players", description = "Retrieve a list of all registered players")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<PlayerDTO>> findAll() {
        var players = playerService.findAll();
        var playersDto = players.stream().map(PlayerDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(playersDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a player by ID", description = "Retrieve a specific player based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Player not found")
    })
    public ResponseEntity<PlayerDTO> findById(@PathVariable Long id) {
        var player = playerService.findById(id);
        return ResponseEntity.ok(new PlayerDTO(player));
    }

    @PostMapping
    @Operation(summary = "Create a new player", description = "Create a new player and return the created player's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid player data provided")
    })
    public ResponseEntity<PlayerDTO> create(@RequestBody PlayerDTO playerDto) {
        var player = playerService.create(playerDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(player.getId())
                .toUri();
        return ResponseEntity.created(location).body(new PlayerDTO(player));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a player", description = "Update the data of an existing player based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player updated successfully"),
            @ApiResponse(responseCode = "404", description = "Player not found"),
            @ApiResponse(responseCode = "422", description = "Invalid player data provided")
    })
    public ResponseEntity<PlayerDTO> update(@PathVariable Long id, @RequestBody PlayerDTO playerDto) {
        var player = playerService.update(id, playerDto.toModel());
        return ResponseEntity.ok(new PlayerDTO(player));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a player", description = "Delete an existing player based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Player deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Player not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
