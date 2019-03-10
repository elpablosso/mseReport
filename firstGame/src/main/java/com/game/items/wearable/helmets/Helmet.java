package com.game.items.wearable.helmets;

import com.game.items.wearable.Armor;
import com.game.items.enums.ArmorType;

public abstract class Helmet extends Armor {
    public Helmet(int id, String name, String description, int value, int levelRequired, int itemLevel, int defenceValue) {
        super(id, name, description, value, levelRequired, itemLevel, ArmorType.HELMET, defenceValue);
    }
}
