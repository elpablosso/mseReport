package application.components.equipment.interfaces;

public interface ItemContainer<T extends Item> {

     void put(T item);
     void remove(T item);
}
