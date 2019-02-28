package application.components.equipment.itemtypes;

import application.components.equipment.interfaces.Item;
import org.springframework.stereotype.Component;

@Component
public abstract class BonusItem implements Item {

    private String itemName;
    private String description;

    public BonusItem(String itemName, String description) {
        this.itemName = itemName;
        this.description = description;
    }

    public void itemInfo(){
        System.out.printf("Item %s : %s", itemName, description);
    }

}
