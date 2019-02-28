package application.components.equipment.interfaces;

public interface Item {

    default void addItem(Item item, ItemContainer container){
        container.put(item);
        System.out.println("ITEM ADDED.");
    }
    default void removeItem(Item item, ItemContainer container){
        container.remove(item);
        System.out.println("ITEM REMOVED.");
    }

}
