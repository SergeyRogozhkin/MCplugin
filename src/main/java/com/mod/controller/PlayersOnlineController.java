package com.mod.controller;

import com.mod.dto.PlayerFullDto;
import com.mod.dto.PlayerShortDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController("players")
public class PlayersOnlineController {

    @GetMapping("{id}/full")
    public ResponseEntity<PlayerFullDto> getFullInfoById(@PathVariable UUID id) {
        //TODO
        return ResponseEntity.ok().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<PlayerShortDto>> getAll() {
        //TODO
        return ResponseEntity.ok().build();
    }
}
