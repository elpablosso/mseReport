package com.game.items;

public abstract class Item {

    private final int itemId;
    private final String itemName;
    private final String itemDescription;
    private final int itemValue;

    public Item(int itemId, String itemName, String itemDescription, int itemValue) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemValue = itemValue;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemValue() {
        return itemValue;
    }
}
