package com.daw.pokedex.model;

import  java.io.*;
public class Sprite {
    private String front_default;
    // Getters and setters

    public Sprite(String front_default) {
        this.front_default = front_default;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
}
