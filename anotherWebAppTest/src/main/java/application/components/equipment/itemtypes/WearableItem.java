package application.components.equipment.itemtypes;

import application.components.equipment.interfaces.Wearable;

import java.util.Map;

public abstract class WearableItem implements Wearable {

    // WEARABLE ITEMS
    private String itemName;
    private Map<String,Integer> bonusValues;
}
