package com.daw.pokedex.model;

import java.util.*;


public class Ability {
    private String name;
    private String url;
    // Getters and setters


    public Ability(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

