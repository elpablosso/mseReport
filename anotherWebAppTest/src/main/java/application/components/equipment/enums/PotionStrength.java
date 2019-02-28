package application.components.equipment.enums;

public enum PotionStrength{

    WEAK(10),
    MEDIUM(25),
    STRONG(50);

    private int valueRecovered;

    PotionStrength(int valueRecovered) {
        this.valueRecovered = valueRecovered;
    }

    public int getValueRecovered() {
        return valueRecovered;
    }
}