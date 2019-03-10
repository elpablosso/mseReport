package com.game.items.wearable;

import com.game.items.enums.ArmorType;
import com.game.items.enums.WearableItemType;
import com.game.items.wearable.WearableItem;

public abstract class Armor extends WearableItem {

    private ArmorType armorType;
    private int defenceValue;

    public Armor(int id, String name, String description, int value, int levelRequired, int itemLevel, ArmorType armorType, int defenceValue) {
        super(id, name, description, value, WearableItemType.ARMOR, levelRequired, itemLevel);
        this.armorType = armorType;
        this.defenceValue = defenceValue;
    }
}
