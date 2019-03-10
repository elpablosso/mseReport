package com.game.items.consumable;

import com.game.items.Item;

public abstract class ConsumableItem extends Item implements Consumable {

    ConsumableItemType consumableItemType;

    public ConsumableItem(int id, String name, String description, int value, ConsumableItemType consumableItemType) {
        super(id, name, description, value);
        this.consumableItemType = consumableItemType;
    }
}
