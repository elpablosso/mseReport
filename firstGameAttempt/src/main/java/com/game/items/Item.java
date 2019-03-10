package com.game.items;

public abstract class Item {

    private final int itemId;
    private final String itemName;
    private final int itemValue;

    public Item(int itemId, String itemName, int itemValue) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemValue() {
        return itemValue;
    }
}
