package com.game.items.containers;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class ItemContainer<T> {

    private Map<? super T, Integer> items;
    private Function<? super T, Integer> numberOfItems = (type) -> items.get(type);

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

    public void put(T itemType, int numberOfItemsToAdd) {
        if (numberOfItemsToAdd > 0) {
            int itemNumber = items.get(itemType);
            itemNumber += numberOfItemsToAdd;
            items.put(itemType, itemNumber);
        } else System.out.println("Wrong number of potions");
    }
}
