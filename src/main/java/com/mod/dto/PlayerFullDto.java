package com.mod.dto;

import java.util.Objects;
import java.util.UUID;

public class PlayerFullDto {
    private UUID id;
    private String name;
    private String skinUrl;
    private String base64Head;
    private String base64Skin;

    public PlayerFullDto() {
    }

    public PlayerFullDto(UUID id, String name, String skinUrl, String base64Head, String base64Skin) {
        this.id = id;
        this.name = name;
        this.skinUrl = skinUrl;
        this.base64Head = base64Head;
        this.base64Skin = base64Skin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerFullDto playerFullDto = (PlayerFullDto) o;
        return Objects.equals(id, playerFullDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, skinUrl, base64Head, base64Skin);
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

    public String getSkinUrl() {
        return skinUrl;
    }

    public void setSkinUrl(String skinUrl) {
        this.skinUrl = skinUrl;
    }

    public String getBase64Head() {
        return base64Head;
    }

    public void setBase64Head(String base64Head) {
        this.base64Head = base64Head;
    }

    public String getBase64Skin() {
        return base64Skin;
    }

    public void setBase64Skin(String base64Skin) {
        this.base64Skin = base64Skin;
    }
}
