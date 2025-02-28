package com.mod.dto;

import java.util.Objects;
import java.util.UUID;

public class PlayerShortDto {
    private UUID id;
    private String name;

    public PlayerShortDto() {
    }

    public PlayerShortDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerShortDto that = (PlayerShortDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
