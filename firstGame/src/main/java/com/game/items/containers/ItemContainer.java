package com.game.items.containers;
import com.game.items.consumable.potions.PotionType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class ItemContainer<T> {

    private Map<T, Integer> items;
    private Function<? extends T, Integer> numberOfItems = (type) -> items.get(type);

    public ItemContainer() {
        items = new HashMap<>();
    }

    public void remove(T itemType , int numberOfItemsToAdd) {
        if (numberOfItemsToAdd <= numberOfItems.apply(itemType)) {
            int itemNumber = items.get(itemType);
            itemNumber -= numberOfItemsToAdd;
            items.put(itemType, itemNumber);
        } else System.out.println("Wrong number of potions");
    }

    public void put(T itemType, int numberOfPotionsToAdd) {
        if (numberOfPotionsToAdd > 0) {
            int potionNumber = items.get(itemType);
            potionNumber += numberOfPotionsToAdd;
            items.put(itemType, potionNumber);
        } else System.out.println("Wrong number of potions");
    }
}
