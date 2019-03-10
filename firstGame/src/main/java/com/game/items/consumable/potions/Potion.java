package com.game.items.consumable.potions;
import com.game.items.consumable.ConsumableItemType;
import com.game.items.consumable.potions.PotionType;
import com.game.items.consumable.ConsumableItem;

public abstract class Potion extends ConsumableItem {
    private PotionType potionType;

    public Potion(int id, String name, String description, int value, PotionType potionType) {
        super(id, name, description, value, ConsumableItemType.POTION);
        this.potionType = potionType;
    }

    public PotionType getPotionType() {
        return potionType;
    }
}
