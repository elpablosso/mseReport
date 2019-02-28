package hello;

import application.components.equipment.enums.PotionStrength;
import application.components.equipment.enums.PotionType;
import application.components.equipment.interfaces.Consumable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Potion implements Consumable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private PotionType potionType;
    private PotionStrength potionStrength;
    private int valueToRecover;
    private String description;


    protected Potion() {
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPotionType(PotionType potionType) {
        this.potionType = potionType;
    }

    public void setPotionStrength(PotionStrength potionStrength) {
        this.potionStrength = potionStrength;
    }

    public void setValueToRecover(int valueToRecover) {
        this.valueToRecover = valueToRecover;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PotionType getPotionType() {
        return potionType;
    }

    public PotionStrength getPotionStrength() {
        return potionStrength;
    }

    public int getValueToRecover() {
        return valueToRecover;
    }

    public String getDescription() {
        return description;
    }
}
