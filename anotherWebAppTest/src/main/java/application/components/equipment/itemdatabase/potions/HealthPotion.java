package application.components.equipment.itemdatabase.potions;

import application.components.equipment.enums.PotionStrength;
import application.components.equipment.enums.PotionType;
import hello.Potion;


public class HealthPotion extends Potion {

    public HealthPotion(PotionStrength potionStrength) {
        setPotionStrength(potionStrength);
        setPotionType(PotionType.HEALTH);
        setValueToRecover(potionStrength.getValueRecovered());
        setDescription("Health potion, that recovers some amount of HP: " + getPotionStrength().getValueRecovered());
    }
}
