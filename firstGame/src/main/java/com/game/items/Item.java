package com.game.items;

public abstract class Item {

    private final int id;
    private final String name;
    private final String description;
    private final int value;

    public Item(int id, String name, String description, int value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }
}
