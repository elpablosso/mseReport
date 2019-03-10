package com.game.items.wearable;

import com.game.items.Item;
import com.game.items.enums.WearableItemType;

public abstract class WearableItem extends Item implements Wearable {

    private final WearableItemType wearableItemType;
    private final int levelRequired;
    private final int itemLevel;
    private boolean isEquipped=false;

    public WearableItem(int id, String name, String description, int value, WearableItemType wearableItemType, int levelRequired, int itemLevel) {
        super(id, name, description, value);
        this.wearableItemType = wearableItemType;
        this.levelRequired = levelRequired;
        this.itemLevel = itemLevel;
    }

    public WearableItemType getWearableItemType() {
        return wearableItemType;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void wear(){
        isEquipped=true;
    }

    public void takeOff(){
        isEquipped=false;
    }
}
